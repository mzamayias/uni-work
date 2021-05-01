clc;
clear all;
close all;

pkg load signal;

b = [32 -14 2 0];
a = [8 -6 1 0];
[r, p, k] = tf2zp(b, a)
