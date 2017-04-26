package mbeans;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import metier.User;
import service.UserService;

@ManagedBean
@SessionScoped
public class UserManagedBean implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserService userService = new UserService();
    
    private String username;
    private String password;
    private String searchUser;
    private Collection<User> searchUsersResults;
    private User selectedUser;
    
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public User getSelectedUser()
    {
        if(selectedUser == null){
            selectedUser = new User();
        }
        return selectedUser;
    }
    
    public void setSelectedUser(User selectedUser)
    {
        this.selectedUser = selectedUser;
    }
    public Collection<User> getSearchUsersResults()
    {
        return searchUsersResults;
    }
    public void setSearchUsersResults(Collection<User> searchUsersResults)
    {
        this.searchUsersResults = searchUsersResults;
    }
    public String getSearchUser()
    {
        return searchUser;
    }
    public void setSearchUser(String searchUser)
    {
        this.searchUser = searchUser;
    }
    
    public String login()
    {
        if("test".equalsIgnoreCase(getUsername()) && "test".equals(getPassword()))
        {
            return "home";
        }
        else
        {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage("username", new FacesMessage("Invalid UserName and Password"));
            return "login";
        }
    }
    
    public String searchUser()
    {
        String username = (this.searchUser == null)? "":this.searchUser.trim();        
        this.searchUsersResults = userService.searchUsers(username);
        System.out.println("Notre liste contient: "+searchUsersResults.size());
        return "home";
    }
    
    public String updateUser()
    {
        userService.update(this.selectedUser);
        return "home";
    }
    public void rowSelect(SelectEvent event){
    	selectedUser =  (User)event.getObject();
    	System.out.println("selectedUser = "+selectedUser.getUsername());	
    }
    public void onUserSelect(SelectEvent event){ 
    	this.selectedUser =  (User)event.getObject();
    	System.out.println("selectedUser = "+selectedUser.getUsername());
    }
    public void onUserUnselect(UnselectEvent event)
    {
    	selectedUser =  null;
    }
}
