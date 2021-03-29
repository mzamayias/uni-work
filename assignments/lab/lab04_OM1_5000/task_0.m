clc;
clear all;
close all;

% anonymous "inline" unit impulse function
d = @(n) n == 0;

% anonymous "inline" unit step function
u = @(n) n > 0;

% domain
n = [0:100];

% singal function
% y(n) = 0.3*x(n) + 0.6*x(n-1) + 0.3*x(n-2) - 0.9*y(n-2)
% y(n) + 0.9*y(n-2) = 0.3*x(n) + 0.6*x(n-1) + 0.3*x(n-2)
% signal to unit inpulse
% h(n) + 0.9*h(n-2) = 0.3*d(n) + 0.6*d(n-1) + 0.3*d(n-2)
% signal to unit step
% s(n) + 0.9*s(n-2) = 0.3*u(n) + 0.6*u(n-1) + 0.3*u(n-2)

% calculate unit impulse using the filter function
a = [1 0.9 0]; % h coefficients
b = [0.3 0.6 0.3]; % d coefficients
y1 = filter(b, a, d(n));
fig1 = plot_figure(1, n, y1, [0:10:100], [-1:0.1:1]);

% calculate unit step using the filter function
a = [1 0.9 0]; % h coefficients
b = [0.3 0.6 0.3]; % d coefficients
y2 = filter(b, a, u(n));
fig2 = plot_figure(2, n, y2, [0:10:100], [0:2]);

% calulate unit step programmatically
y3 = zeros(1, length(n));
y3(1) = 1;
for i = 2:length(n)
    y3(i) = 0.3 * u(n(i)) +0.6 * u(n(i) - 1) + 0.3 * u(n(i) - 2) - 0.9 * y3(i - 1);
endfor
fig3 = plot_figure(3, n, y3, [0:10:100], [0:2]);

% calulate unit impulse programmatically
y4 = zeros(1, length(n));
y4(1) = 1;
for i = 2:length(n)
    y4(i) = 0.3 * d(n(i)) +0.6 * d(n(i) - 1) + 0.3 * d(n(i) - 2) - 0.9 * y4(i - 1);
endfor
fig4 = plot_figure(4, n, y4, [0:10:100], [-1:0.1:1]);

waitfor(fig4);
