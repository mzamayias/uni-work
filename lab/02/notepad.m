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
waitfor(f1);
% <<<


