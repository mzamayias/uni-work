clc;
clear all;
close all;

pkg load signal;

% >>> Task 1
Wp = 2 * pi * 1000 * 4; % Passband corner (cutoff) frequency
Ws = 2 * pi * 1000 * 8; % Stopband corner frequency
Rp = 1; % Passband ripple
Rs = 40; % Stopband ripple
[n, Wn] = buttord(Wp, Ws, Rp, Rs, 's');
[b, a] = butter(n, Wn, 's');
W = findW(b, a);
H = freqss(b, a);
figure_1 = plot_plot(1, W / (2 * pi), 20 * log10(abs(H)), [0:4000:16000], [20:-20:-100]);

[z, p] = tf2zp(b, a);
figure_2 = figure(2);
figure_2 = plot_zplane(2, z, p, [-5:1:2], [-3:1:3]);
%   zplane(z, p);
% <<< Task 1

% >>> Task 2
Wp = 2 * pi * 1000 * 200; % Passband corner (cutoff) frequency
Ws = 2 * pi * 1000 * 400; % Stopband corner frequency
Rp = 3; % Passband ripple
Rs = 60; % Stopband ripple
[n, Wn] = buttord(Wp, Ws, Rp, Rs, 's');
[b, a] = butter(n, Wn, 's');
W = findW(b, a);
H = freqss(b, a);
figure_3 = figure(3);
plot(W / (2 * pi), 20 * log10(abs(H)));

[z, p] = tf2zp(b, a);
figure_4 = figure(4);
zplane(z, p);
% <<< Task 2

waitfor(figure_4);
