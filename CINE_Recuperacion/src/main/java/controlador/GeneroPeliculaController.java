package controlador;

import modelo.GeneroPelicula;
import controlador.util.JsfUtil;
import controlador.util.JsfUtil.PersistAction;
import dao.GeneroPeliculaFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("generoPeliculaController")
@SessionScoped
public class GeneroPeliculaController implements Serializable {

    @EJB
    private dao.GeneroPeliculaFacade ejbFacade;
    private List<GeneroPelicula> items = null;
    private GeneroPelicula selected;

    public GeneroPeliculaController() {
    }

    public GeneroPelicula getSelected() {
        return selected;
    }

    public void setSelected(GeneroPelicula selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private GeneroPeliculaFacade getFacade() {
        return ejbFacade;
    }

    public GeneroPelicula prepareCreate() {
        selected = new GeneroPelicula();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/vistas").getString("GeneroPeliculaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/vistas").getString("GeneroPeliculaUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/vistas").getString("GeneroPeliculaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<GeneroPelicula> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/vistas").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/vistas").getString("PersistenceErrorOccured"));
            }
        }
    }

    public GeneroPelicula getGeneroPelicula(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<GeneroPelicula> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<GeneroPelicula> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = GeneroPelicula.class)
    public static class GeneroPeliculaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            GeneroPeliculaController controller = (GeneroPeliculaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "generoPeliculaController");
            return controller.getGeneroPelicula(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof GeneroPelicula) {
                GeneroPelicula o = (GeneroPelicula) object;
                return getStringKey(o.getIdgen());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), GeneroPelicula.class.getName()});
                return null;
            }
        }

    }

}
