clc;
clear all;
close all;

delta_function; % Source task_0.m file.

% x(n) = {-2, 1, -1/3, 1/2, 2, 1, 0, 1, 0, 0, 3}
% x(n) = 2d(n+3) + d(n+2) - (1/3)d(n+1) + (1/2)d(n) + 2d(n-1) + d(n-2) + d(n-4) + 3d(n-7)

n_low = -3;
n_high = 7;

n = n_low:n_high;
x = zeros(1, length(n));

for i = x
    y(i) = -2 * delta_function(n(i) + 3) + delta_function(n(i) + 2) - 1/3 * delta_function(n(i) + 1) + 1/2 + delta_function(n(i)) + 2 * delta_function(n(i) - 1) + delta_function(n(i) - 2) + delta_function(n(i) - 4) + 3 * delta_function(n(i) - 7);
endfor

fig1 = figure(1);
stem(x, y);
waitfor(fig1);
