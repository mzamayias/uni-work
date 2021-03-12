clc;
clear all;
close all;

% Required by the dirac function.
pkg load symbolic;

% Delta function:
% y is vertical axis
% x is horizotanl axis
% k is the horizal shift of y
% lower_limit_n is the start int of x
% upper_limit_n is the end int of x
function [y, x] = delta_function(x)
    % x = [lower_limit_n : upper_limit_n]; % Make x.
    y = dirac(x); % Apply dirac to x.
    y(y == inf) = 1; % Replace inf with 1.
    y = circshift(y, k); % Shift indices of vector 'y' by 'k'.
endfunction
