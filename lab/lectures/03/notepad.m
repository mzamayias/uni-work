clc;
clear all;
close all;

d = @(n) n == 0;
n = 0:10;
a = [1 -1.1 0.5 0 0.3]; % h coefficients
b = [0.5 -0.2 0 0 0]; % d coefficients
h = filter(b, a, d(n));
f5 = plot_figure(5, n, h, [0:1:10], [-0.5:0.1:0.5]);

x = [5 1 1 1 0 0 1 1 1 0];
h_prime = conv(x, h);
y = filter(b, a, x);
f6 = figure(6);
plot([0:20], h_prime, [0:20], y, 'r')
xlim([0 20]);
ylim([-3 3]);
set(gca, 'xtick', [0:2:20]);
set(gca, 'ytick', [-3:1:3]);
waitfor(f6);
