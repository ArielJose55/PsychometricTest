
package prociencia.views.panels;

import prociencia.logic.core.entities.Ocupacion;

/**
 *
 * @author Klac
 */
public interface PanelValidador {
    public boolean camposVacios();
    public void throwWarning();
    public Ocupacion getOcupacion();
}
