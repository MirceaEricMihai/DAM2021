package com.example.telegram;

import java.util.List;

public interface IResponse {
    public void onSuccess(List<Cont> list);
    public void onError(String errorMessage);
}
