package ru.pda;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        int counter = 0;
        for (int i : source) {
            if (i >= treshold) {
                logger.log("Элемент [" + i + "] проходит\n");
                result.add(i);
                counter++;
            } else logger.log("Элемент [" + i + "] не проходит\n");
        }
        logger.log("Прошло фильтр " + counter + " элемента из " + source.size() + "\n");
        return result;
    }
}
