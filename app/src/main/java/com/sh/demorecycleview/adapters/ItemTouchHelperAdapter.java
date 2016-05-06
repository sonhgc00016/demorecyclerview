package com.sh.demorecycleview.adapters;

/**
 * Created by SonH on 2016-05-06.
 */
public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);

    boolean onItemDismiss(int position);
}
