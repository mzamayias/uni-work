clc;
clear all;
close all;

task_0; % Source task_0.m file.

% ---
% Graph 1
% ---

k = -5;
n_low = -10;
n_high = 8;
[y, x] = delta_k(k, n_low, n_high);
y *= 3;

% Plot y vs x.
d1 = figure(1);
stem(x, y);

%{
% Plot settings.
x_ticks = [min(x) - 1:max(x) + 1];
y_ticks = [min(x):max(x)];
axis_range = [min(x_ticks), max(x_ticks), min(y_ticks), max(y_ticks)];
axis(axis_range, "square");
xticks(x_ticks);
yticks(y_ticks);
grid on;
%}

% ---
% Graph 2
% ---

k0 = 1;
n0_low = -2;
n0_high = 12;
[y0, x0] = delta_k(k0, n0_low, n0_high);

k1 = 10;
n1_low = n0_low;
n1_high = n0_high;
[y1, x1] = delta_k(k1, n1_low, n1_high);
y = y0 - y1;

% Plot y vs x.
d2 = figure(2);
stem(x1, y);

% ---
% Graph 3
% ---

k0 = 5;
n0_low = -10;
n0_high = 10;
[y0, x0] = delta_k(k0, n0_low, n0_high);

k1 = 2;
n1_low = n0_low;
n1_high = n0_high;
[y1, x1] = delta_k(k1, n1_low, n1_high);
y = y0 * (ones(length(y0)) + y1);

% Plot y vs x.
d3 = figure(3);
stem(x1, y);

% ---
% Graph 4
% ---

k0 = -10;
n0_low = -20;
n0_high = 20;
[y0, x0] = delta_k(k0, n0_low, n0_high);

k1 = 7;
n1_low = n0_low;
n1_high = n0_high;
[y1, x1] = delta_k(k1, n1_low, n1_high);

y = sqrt(pi) * (y0 - 3 * y1);

% Plot y vs x.
d4 = figure(4);
stem(x0, y);

k = 3;
n_low = -1;
n_high = 1;
[y, x] = u(k, n_low, n_high);
d5 = figure(5);
stem(x, y);

% Wait for plots.
waitfor([d1, d2, d3, d4, d5]);
