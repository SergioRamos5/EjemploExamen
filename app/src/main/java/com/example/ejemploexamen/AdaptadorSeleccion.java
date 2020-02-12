package com.example.ejemploexamen;

import android.util.SparseBooleanArray;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

abstract class AdaptadorSeleccion extends RecyclerView.Adapter implements View.OnLongClickListener, View.OnClickListener {

    private SparseBooleanArray selectedItems;

    public AdaptadorSeleccion() {
        selectedItems = new SparseBooleanArray();
    }

    boolean isSelected(int position) {
        return getSelectedItems().contains(position);
    }

    boolean toggleSelection(int position) {
        boolean seleccionado;
        if (selectedItems.get(position, false)) {
            selectedItems.delete(position);
            seleccionado = false;
        } else {
            selectedItems.put(position, true);
            seleccionado = true;
        }
        notifyItemChanged(position);
        return seleccionado;
    }

    void clearSelection() {
        List<Integer> selection = getSelectedItems();
        selectedItems.clear();
        for (Integer i : selection) {
            notifyItemChanged(i);
        }
    }

    int getSelectedItemCount() {
        return selectedItems.size();
    }

    List<Integer> getSelectedItems() {
        List<Integer> items = new ArrayList<>(selectedItems.size());
        for (int i = 0; i < selectedItems.size(); ++i) {
            items.add(selectedItems.keyAt(i));
        }
        return items;
    }
}
