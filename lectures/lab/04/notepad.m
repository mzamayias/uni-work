clc;
clear all;
close all;

% >>> Task 1
f1 = 2;
Fs1 = 100
Ts1 = 1 / Fs1;
t1 = 0:Ts1:Ts1*50;
x1 = sin(2 * pi * f1 * t1);
f1 = figure(1);
plot(t1, x1);
% <<<

% >>> Task 2
f2 = 20;
Fs2 = 0.5 * 10.^3;
Ts2 = 1 / Fs2;
t2 = 0:Ts2:Ts2*50;
x2 = 3 * cos(2 * f2 * pi * t2 + 5);
f2 = figure(2);
plot(t2, x2);
% <<<

f3 = figure(3);
plot(t1, x1, t2, x2);

% >>> Task 3
Fs3 = 6000;
Ts3 = 1 / Fs3;
t3 = 0:Ts3:Ts3*50;
c = 10;
w1 = 5 * cos(1000 * pi * t3);
w2 = 15 * cos(2000 * pi * t3);
w3 = 5 * cos(3000 * pi * t3);
x3 = c + w1 + w2 + w3;
f4 = figure(4);
plot(t3, x3);
% <<<

waitfor(f1);
