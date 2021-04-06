function f = plot_figure(figure_no, x, y, xtick, ytick)
    f = figure(figure_no);
    stem(x, y);
    xlim([min(xtick) max(xtick)]);
    ylim([min(ytick) max(ytick)]);
    set(gca, 'xtick', xtick);
    set(gca, 'ytick', ytick);
endfunction
