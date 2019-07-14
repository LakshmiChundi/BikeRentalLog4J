package com.bikerentallog4j.model.services.factory;

/**     @author Lakshmi Chundi**/


import com.bikerentallog4j.model.services.manager.PropertyManager;
import com.bikerentallog4j.model.business.exception.ServiceLoadException;
import com.bikerentallog4j.model.services.IService;

	
public class ServiceFactory
{

	/**
	 * 
	 * @param serviceName
	 *                 Name of the service interface
	 * @return
	 *                 Implementation of the service interface
	 *                 
	 * @throws ServiceLoadException
	 *                 Thrown when the implementation for the "serviceName" cannot be found and hence loaded
	 */


   public IService getCustomerService(String serviceName) throws ServiceLoadException {
		try {
				Class<?> c = Class.forName(getImplName(serviceName));
				return (IService) c.newInstance();
			} catch (Exception excp) {
				serviceName = serviceName + " not loaded";
				throw new ServiceLoadException(serviceName, excp);
			}
		}
   
       


	public IService getBikeService(String serviceName) throws ServiceLoadException {
		try {
			Class<?> c = Class.forName(getImplName(serviceName));
			return (IService) c.newInstance();
		} catch (Exception excp) {
			serviceName = serviceName + " not loaded";
			throw new ServiceLoadException(serviceName, excp);
		}
	}
	

	public IService getReserveBikeService(String serviceName) throws ServiceLoadException
	   {
			try {
				Class<?> c = Class.forName(getImplName(serviceName));
				return (IService) c.newInstance();
			} catch (Exception excp) {
				serviceName = serviceName + " not loaded";
				throw new ServiceLoadException(serviceName, excp);
			}
	   }

	public IService getBikeRentService(String serviceName) throws ServiceLoadException {
		
		try {
			Class<?> c = Class.forName(getImplName(serviceName));
			return (IService) c.newInstance();
		} catch (Exception excp) {
			serviceName = serviceName + " not loaded";
			throw new ServiceLoadException(serviceName, excp);
		}
	}

	
	public IService getBikeWorkShopService(String serviceName) throws ServiceLoadException {
		
		try {
			Class<?> c = Class.forName(getImplName(serviceName));
			return (IService) c.newInstance();
		} catch (Exception excp) {
			serviceName = serviceName + " not loaded";
			throw new ServiceLoadException(serviceName, excp);
		}
	}
	
	/**
	 * 
	 * @param serviceName
	 * @return
	 * @throws Exception
	 */
	private String getImplName(String serviceName) throws Exception {
		return PropertyManager.getPropertyValue(serviceName);
	}

	
	private static ServiceFactory serviceFactoryInstance;
	public static ServiceFactory getInstance() 
	{
		if (serviceFactoryInstance == null)
			serviceFactoryInstance = new ServiceFactory();		
		return serviceFactoryInstance;
	}

}
	
	

