clc;
clear all;
close all;

% >>> Lab_04_Students.pdf - Page 7 of 32
x = [-4:1:4];
term0 = 0.5 * delta_function(1, x);
term1 = 0.9 * delta_function(0, x);
term2 = 0.75 * delta_function(-2, x);
term3 = delta_function(-3, x);
y = term0 + term1 + term2 + term3;
f1 = plot_figure(1, x, y, x, [0:0.1:1.5]);
% <<<

% >>> Lab_04_Students.pdf - Page 25 of 32
% y(n) = -0.9 * y(n-1) + x(n)
% h(n) = -0.9 * h(n-1) + d(n)
n = 0:100;
a = [1, 0.9]; % h coefficients
b = [1, 0]; % d coefficients
h = filter(b, a, delta_function(0, n));
f2 = plot_figure(2, n, h, [0:10:100], [-1:0.1:1]);
% <<<

% >>> Lab_04_Students.pdf - Page 23 of 32
% y(n) = -0.9 * y(n-1) + x(n)
% h(n) = -0.9 * h(n-1) + d(n)
d = @(n) n == 0;
h(1) = 1;
for n = 2:101
    h(n) = -0.9 * h(n - 1) + d(n);
endfor
f3 = plot_figure(3, 0:100, h, [0:10:100], [-1:0.1:1]);
waitfor(f3);
% <<<
