function W = findW(b, a)
    w = 200;
    w = double(w);
    wlen = w;
    w_long = freqint(b, a, wlen);
    xi = linspace(1, length(w_long), wlen).';
    W = 10.^interp1(1:length(w_long), log10(w_long), xi, 'linear');

    function w = freqint(a, b, npts)

        ep = roots(b);
        tz = roots(a);

        if isempty(ep), ep=-1000; end
        ez = [ep(imag(ep) >= 0); tz(abs(tz) < 1e5 & imag(tz) >= 0)];
        integ = abs(ez) < 1e-10;
        highfreq = round(log10(max(3 * abs(real(ez) + integ) + 1.5 * imag(ez))) + 0.5);
        lowfreq = round(log10(0.1 * min(abs(real(ez + integ)) + 2 * imag(ez))) - 0.5);
        diffzp = length(ep) - length(tz);
        w = logspace(lowfreq, highfreq, npts + diffzp + 10 * (sum(abs(imag(tz)) < abs(real(tz))) > 0));
        ez = ez(imag(ez) > abs(real(ez)));

        if ~isempty(ez)
            f = w;
            npts2 = 2 + 8 / ceil(abs((diffzp + eps) / 10));
            [dum, ind] = sort(-abs(real(ez)));
            z = [];

            for i = ind'
                r1 = max([0.8 * imag(ez(i)) - 3 * abs(real(ez(i))), 10^lowfreq]);
                r2 = 1.2 * imag(ez(i)) + 4 * abs(real(ez(i)));
                z = z(z > r2 | z < r1);
                f = f(f > r2 | f < r1);
                z = [z, logspace(log10(r1), log10(r2), sum(w <= r2 & w >= r1) + npts2)];
            end

            w = sort([f, z]);
        end

        w = w(:);
        w = double(w);
