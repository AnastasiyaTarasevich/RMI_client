package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyMath extends Remote {
    int[] Factorials(int[] num) throws RemoteException;
    double [] SqureRoots(int[] num) throws RemoteException;
}
