#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.fb.models;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class UserFacebook {
    String id;
    String email;

    public UserFacebook(String id, String email) {
        super();
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
