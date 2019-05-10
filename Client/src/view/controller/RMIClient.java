package controller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmiinterface.*;

/**
 *
 * @author Admin
 */
public class RMIClient {
    RMIInterface rmiServer;
    Registry registry;

    public RMIClient(String address, int port) {
        try {
            registry = LocateRegistry.getRegistry(address, port);
            rmiServer = (RMIInterface)(registry.lookup("rmiServer"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
    
    public int Register(User user) {
        try {
            return rmiServer.Register(user);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return 2;
        }
    }
    
    public User Login(User user) {
        try {
            return rmiServer.Login(user);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public int CreateGroup(User user, Group group) {
        try {
            return rmiServer.CreateGroup(user, group);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return 2;
        }
    }
    
    public int JoinGroup(User user, Group group) {
        try{
            return rmiServer.JoinGroup(user, group);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return 2;
        }
    }
    
    public ArrayList<Group> GetListGroup(User user) {
        try {
            return rmiServer.GetListGroup(user);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Message> GetListMessage(Group group) {
        try {
            return rmiServer.GetListMessage(group);
        } catch (RemoteException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void AddMessage(Message message) {
        try {
            rmiServer.AddMessage(message);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    
}
