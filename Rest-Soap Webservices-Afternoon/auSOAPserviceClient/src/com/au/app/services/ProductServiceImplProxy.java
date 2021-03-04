package com.au.app.services;

public class ProductServiceImplProxy implements com.au.app.services.ProductServiceImpl {
  private String _endpoint = null;
  private com.au.app.services.ProductServiceImpl productServiceImpl = null;
  
  public ProductServiceImplProxy() {
    _initProductServiceImplProxy();
  }
  
  public ProductServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initProductServiceImplProxy();
  }
  
  private void _initProductServiceImplProxy() {
    try {
      productServiceImpl = (new com.au.app.services.ProductServiceImplServiceLocator()).getProductServiceImpl();
      if (productServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)productServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)productServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (productServiceImpl != null)
      ((javax.xml.rpc.Stub)productServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.au.app.services.ProductServiceImpl getProductServiceImpl() {
    if (productServiceImpl == null)
      _initProductServiceImplProxy();
    return productServiceImpl;
  }
  
  public com.au.app.Product getProduct(int id) throws java.rmi.RemoteException{
    if (productServiceImpl == null)
      _initProductServiceImplProxy();
    return productServiceImpl.getProduct(id);
  }
  
  public com.au.app.Product[] getAllProducts() throws java.rmi.RemoteException{
    if (productServiceImpl == null)
      _initProductServiceImplProxy();
    return productServiceImpl.getAllProducts();
  }
  
  public boolean deleteProduct(int id) throws java.rmi.RemoteException{
    if (productServiceImpl == null)
      _initProductServiceImplProxy();
    return productServiceImpl.deleteProduct(id);
  }
  
  public boolean addProduct(com.au.app.Product p) throws java.rmi.RemoteException{
    if (productServiceImpl == null)
      _initProductServiceImplProxy();
    return productServiceImpl.addProduct(p);
  }
  
  
}