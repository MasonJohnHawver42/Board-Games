
/**
 * Write a description of class Move here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NormalMove extends Move
{
    public NormalMove(Piece p, ChessTile t) {
        super(p, t);
        piece = p;
        from = p.getTile();
        to = t;
        captured = to.getPiece();
        
        highlight = to;
    }
    
    public void Do() {
        from.removePiece();
        to.placePiece(piece);
        if(captured != null) { captured.capture(); }
        
        piece.setTile(to); 
    }
    public void Undo() {
        from.placePiece(piece);
        to.placePiece(captured);
        if(captured != null) { captured.redeem(); }
        
        piece.setTile(from);
    }
    
    public String getNotation() {
        return piece.getName() + (piece instanceof Pawn ? "" : " ") + ( captured == null ? "" : "x ") + to.getName();
    }
    
    public final ChessTile from, to;
    public final Piece piece;
    public Piece captured;
}
