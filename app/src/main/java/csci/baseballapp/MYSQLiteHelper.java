package csci.baseballapp;

import android.database.sqlite.SQLiteOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lumpy on 11/29/14.
 */
public class MYSQLiteHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "playerStatsManager";


    public MYSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Log.d("check", "found oncreate");
        //db.execSQL("DROP TABLE IF EXISTS players");

    }

    public void test(){
        this.getWritableDatabase().execSQL("DROP TABLE IF EXISTS players");
        String CREATE_PLAYER_TABLE = "CREATE TABLE players ( " + "id INTEGER PRIMARY KEY AUTOINCREMENT, " + "team INTEGER, " + "name TEXT, " + "position INTEGER, " + "bats INTEGER, " + "hits INTEGER )";
        this.getWritableDatabase().execSQL(CREATE_PLAYER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS players");
        this.onCreate(db);
    }

    public static final String TABLE_PLAYER_STATS = "players",
    KEY_TEAMID = "team",
    KEY_ID = "id",
    KEY_NAME = "name",
    KEY_POSITION = "position",
    KEY_AT_BATS = "bats",
    KEY_HITS = "hits";

    private static final String[] COLUMNS = {KEY_ID, KEY_TEAMID, KEY_NAME, KEY_POSITION, KEY_AT_BATS, KEY_HITS};

    public void createPlayerStats(Player player) {
        Log.d("addPlayer", player.toString());
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TEAMID, player.teamID);
        values.put(KEY_POSITION, player.m_positionArray);
        values.put(KEY_NAME, player.m_lastName);
        values.put(KEY_AT_BATS, player.stats.m_atBats);
        values.put(KEY_HITS, player.stats.m_hits);

        db.insert(TABLE_PLAYER_STATS, null, values);
        db.close();
    }

    public Player getPlayer(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PLAYER_STATS, COLUMNS, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Player player = new Player();
        player.playerID = Integer.parseInt(cursor.getString(0));
        player.teamID = Integer.parseInt(cursor.getString(1));
        player.m_lastName = cursor.getString(2);
        player.m_positionArray = Integer.parseInt(cursor.getString(3));
        player.stats.m_atBats = Integer.parseInt(cursor.getString(4));
        player.stats.m_hits = Integer.parseInt(cursor.getString(5));

        Log.d("getPlayer(" + id + ")", player.toString());
        //db.close();
        //cursor.close();
        return player;
    }

    public void deletePlayer(Player player){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PLAYER_STATS, KEY_ID + "=?", new String[] {String.valueOf(player.playerID)});
        db.close();
        Log.d("deletePlayer", player.toString());
    }

    public int getPlayersCount(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PLAYER_STATS, null);
        int count = cursor.getCount();
        db.close();
        cursor.close();


        return count;
    }

    public int updatePlayer(Player player){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TEAMID, player.teamID);
        values.put(KEY_POSITION, player.m_positionArray);
        values.put(KEY_NAME, player.m_lastName);
        values.put(KEY_AT_BATS, player.stats.m_atBats);
        values.put(KEY_HITS, player.stats.m_hits);

        int thisRow = db.update(TABLE_PLAYER_STATS, values, KEY_ID + "=?", new String[] {String.valueOf(player.playerID)});
        db.close();
        return thisRow;
    }

    public List<Player> getAllPlayersFromTeam(int teamID){
        List<Player> players = new ArrayList<Player>();
        String query = "Select * From " + TABLE_PLAYER_STATS + " where team = " + teamID;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Player player = null;
        if(cursor.moveToFirst()){
            do {
                player = new Player();
                player.playerID = Integer.parseInt(cursor.getString(0));
                player.teamID = Integer.parseInt(cursor.getString(1));
                player.m_lastName = cursor.getString(2);
                player.m_positionArray = Integer.parseInt(cursor.getString(3));
                player.stats.m_atBats = Integer.parseInt(cursor.getString(4));
                player.stats.m_hits = Integer.parseInt(cursor.getString(5));

                players.add(player);
            }
            while (cursor.moveToNext());
        }
        Log.d("getAllPlayers()", players.toString());

        return players;
    }

    public List<Player> getAllPitchersFromTeam(int teamID){
        List<Player> players = new ArrayList<Player>();
        String query = "Select * From " + TABLE_PLAYER_STATS + " where position = " + 0 + " and team = " + teamID;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        Player player = null;
        if(cursor.moveToFirst()){
            do {
                player = new Player();
                player.playerID = Integer.parseInt(cursor.getString(0));
                player.teamID = Integer.parseInt(cursor.getString(1));
                player.m_lastName = cursor.getString(2);
                player.m_positionArray = Integer.parseInt(cursor.getString(3));
                player.stats.m_atBats = Integer.parseInt(cursor.getString(4));
                player.stats.m_hits = Integer.parseInt(cursor.getString(5));

                players.add(player);
            }
            while (cursor.moveToNext());
        }
        Log.d("getAllPitchers()", players.toString());

        return players;
    }
}
