function [y, x] = delta_function(k, x)
    pkg load symbolic;
    % x = [lower_limit_n : upper_limit_n]; % Make x.
    y = dirac(x); % Apply dirac to x.
    y(y == inf) = 1; % Replace inf with 1.
    y = circshift(y, -k); % Shift indices of vector 'y' by 'k'.
endfunction
