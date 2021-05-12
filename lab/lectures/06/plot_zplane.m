function f = plot_zplane(figure_no, x, y, xtick, ytick)
    f = figure(figure_no);
    zplane(x, y);
    xlim([min(xtick) max(xtick)]);
    ylim([min(ytick) max(ytick)]);
    set(gca, 'xtick', xtick);
    set(gca, 'ytick', ytick);
endfunction
