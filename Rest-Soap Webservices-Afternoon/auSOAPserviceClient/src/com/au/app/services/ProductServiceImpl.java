/**
 * ProductServiceImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.au.app.services;

public interface ProductServiceImpl extends java.rmi.Remote {
    public com.au.app.Product getProduct(int id) throws java.rmi.RemoteException;
    public com.au.app.Product[] getAllProducts() throws java.rmi.RemoteException;
    public boolean deleteProduct(int id) throws java.rmi.RemoteException;
    public boolean addProduct(com.au.app.Product p) throws java.rmi.RemoteException;
}
