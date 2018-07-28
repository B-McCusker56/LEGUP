package puzzle.treetent;

import model.gameboard.Element;
import ui.boardview.ElementView;

import java.awt.*;

public class TreeTentClueView extends ElementView
{

    private static final Font FONT = new Font("TimesRoman", Font.BOLD, 16);
    private static final Color FONT_COLOR = Color.BLACK;

    public TreeTentClueView(TreeTentClue clue)
    {
        super(clue);
    }

    /**
     * Gets the Element associated with this view
     *
     * @return Element associated with this view
     */
    @Override
    public TreeTentClue getElement()
    {
        return (TreeTentClue)super.getElement();
    }

    @Override
    public void draw(Graphics2D graphics2D)
    {
        graphics2D.setColor(FONT_COLOR);
        graphics2D.setFont(FONT);
        FontMetrics metrics = graphics2D.getFontMetrics(FONT);
        String value;

        TreeTentClue clue = getElement();
        switch(clue.getType())
        {
            case CLUE_NORTH:
                value = String.valueOf(clue.getData() + 1);
                break;
            case CLUE_EAST:
                value = String.valueOf(clue.getData());
                break;
            case CLUE_SOUTH:
                value = String.valueOf(clue.getData());
                break;
            case CLUE_WEST:
                value = TreeTentClue.colNumToString(clue.getData() + 1);
                break;
            default:
                value = "";
        }

        int xText = location.x + (size.width - metrics.stringWidth(value)) / 2;
        int yText = location.y + ((size.height - metrics.getHeight()) / 2) + metrics.getAscent();
        graphics2D.drawString(value, xText, yText);
    }
}