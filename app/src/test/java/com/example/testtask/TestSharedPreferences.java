package com.example.testtask;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;

public class TestSharedPreferences {
    private SharedPreferences mPreferences;
    private Context mContext;
    @Before
   public void setPreferences(){
        mPreferences = Mockito.mock(SharedPreferences.class);
        mContext = Mockito.mock(Context.class);
        Mockito.when (mContext.getSharedPreferences(anyString(), anyInt())).thenReturn(mPreferences);
    }
    @Test
   public void testToken(){
        Mockito.when(mPreferences.getString(anyString(), anyString())).thenReturn("token");
        //PrefsImpl.initSharedPrefernces(mPreferences)
        assertEquals("token", mPreferences.getString("1",""));
    }
}
