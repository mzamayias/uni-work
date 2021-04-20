clc;
clear all;
close all;

% Required by the dirac function.
pkg load symbolic;

% Delta function:
% x is function domain, set by lower_limit_n and upper_limit_n
% y is f(x)
% k is the horizontal shift of y
% lower_limit_n is where x starts
% upper_limit_n is where x ends
function [y, x] = delta_k(k, lower_limit_n, upper_limit_n)
    x = [lower_limit_n:upper_limit_n]; % Domain of delta function.
    y = dirac(x); % dirax(x).
    y(y == inf) = 1; % Replace inf with 1.
    y = circshift(y, k); % Shift indices of vector 'y' by 'k'.
endfunction

function [y, x] = u(k, lower_limit_n, upper_limit_n)
    x = [lower_limit_n:upper_limit_n]; % Domain of delta function.
    y = ones(length(x)) * k;
endfunction
