

package org.cvut.vrchlpet.Metamodelar.visualization;

/**
 *
 * @author Vrchlavsky Petr
 * @version 1.0
 */
public class ConnectionLabel extends Label{

    public static final ConnectionLabelPosition DEFAULT_CON_LABEL_POS = ConnectionLabelPosition.center;

    private ConnectionLabelPosition connectionLabelPosition;

    public ConnectionLabel() {
        this.connectionLabelPosition = DEFAULT_CON_LABEL_POS;
    }

    public ConnectionLabel(ConnectionLabelPosition pos) {
        this.connectionLabelPosition = pos;
    }

    /**
     * @return the connectionLabelPosition
     */
    public ConnectionLabelPosition getConnectionLabelPosition() {
        return connectionLabelPosition;
    }

    /**
     * @param connectionLabelPosition the connectionLabelPosition to set
     */
    public void setConnectionLabelPosition(ConnectionLabelPosition connectionLabelPosition) {
        this.connectionLabelPosition = connectionLabelPosition;
    }
}
