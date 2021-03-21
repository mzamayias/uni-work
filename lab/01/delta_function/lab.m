clc;
clear all;
close all;

% Following code privided by lab assistant.
% Delta function:
function [n, d] = dk(k, minN, maxN)
    n = [minN : maxN];
    d = zeros(1, length(n));
    for i = 1 : length(n)
        if n(i) == k
            d(i) = 1;   
            break;
        end
    end
endfunction

% Executing delta function.
[n, d] = dk(2, -5, 5)

% Plot n vs d.
stem(n, d);
waitfor(figure(1));
