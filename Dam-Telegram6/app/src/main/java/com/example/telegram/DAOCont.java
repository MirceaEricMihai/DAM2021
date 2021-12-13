package com.example.telegram;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOCont {

    private DatabaseReference databaseReference;
    public DAOCont()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Cont.class.getSimpleName());
    }

    public Task<Void> add(Cont cnt)
    {
        return databaseReference.push().setValue(cnt);
    }
}
