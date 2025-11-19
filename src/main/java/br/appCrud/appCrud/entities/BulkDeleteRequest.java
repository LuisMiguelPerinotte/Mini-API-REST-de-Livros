package br.appCrud.appCrud.entities;

import java.util.ArrayList;
import java.util.List;

public class BulkDeleteRequest {
    private List<Integer> ids = new ArrayList<>();

    // getters and setters
    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
