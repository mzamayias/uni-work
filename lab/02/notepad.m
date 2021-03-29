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
% f1 = plot_figure(1, x, y, x, [0:0.1:1.5]);
% <<<

% >>> Lab_04_Students.pdf - Page 25 of 32
% y(n) = -0.9 * y(n-1) + x(n)
% h(n) = -0.9 * h(n-1) + d(n)
% h(n) = 0*
n = 0:20;
a = [1 0 0 0 0 0]; % h coefficients
b = [0 2 4 6 4 2]; % d coefficients
h = filter(b, a, delta_function(0, n));
f2 = plot_figure(2, n, h, [0:1:5], [0:1:10]);
waitfor(f2);
% <<<
quit();
% >>> Lab_04_Students.pdf - Page 23 of 32
% y(n) = -0.9 * y(n - 1) + x(n)
% h(n) = -0.9 * h(n - 1) + d(n)
d = @(n) n == 0; % delta funtion. resolves warning: warning: inline is obsolete; use anonymous functions instead
h(1) = 1;
for n = 2:101
    h(n) = -0.9 * h(n - 1) + d(n);
endfor
% f3 = plot_figure(3, 0:100, h, [0:10:100], [-1:0.1:1]);
% <<<

% >>> Lab_04_Students.pdf - Page 28 of 32
% y(n) = y(n - 1) + x(n) – x(n - 8)
% s(n) = s(n - 1) + u(n) – u(n - 8)
n = 0:100;
u = @(n) n >= 0;
a = [1 -1 0 0 0 0 0 0 0]; % h coefficients
b = [1 0 0 0 0 0 0 0 -1]; % d coefficients
s = filter(b, a, u(n));
% f4 = plot_figure(4, n, s, [0:10:100], [0:1:10]);
% <<<
