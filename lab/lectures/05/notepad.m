clc;
clear all;
close all;

pkg load signal;

% b = [0 1 0];
% a = [3 -4 1];
% [r, p, k] = residuez(b, a)

% b = [34 0 4];
% a = [16 12 2];
% [r, p, k] = residuez(b, a)

b = [18 0 0 0];
a = [18 3 -4 -1];
[r, p, k] = residuez(b, a)

help residuez
