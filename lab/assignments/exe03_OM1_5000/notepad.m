% Clear console
clc;
clear all;
close all;

% Load module
pkg load signal;

% Task 1.i
b = [32 -14 2 0];
a = [8 -6 1 0];
[r, p, k] = tf2zp(b, a)

% Task 2
