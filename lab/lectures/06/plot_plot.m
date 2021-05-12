function f = plot_plot(figure_no, x, y, xtick, ytick)
    f = figure(figure_no);
    plot(x, y);
    xlim([min(xtick) max(xtick)]);
    ylim([min(ytick) max(ytick)]);
    set(gca, 'xtick', xtick);
    set(gca, 'ytick', ytick);
endfunction
