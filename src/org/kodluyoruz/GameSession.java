package org.kodluyoruz;
class GameSession extends BasicGame //Farkli oyun tipleri icin farkli classlar Game classini extend edebilir.
{

    public GameSession(String mapSize)
    {
        this.setMapSize(mapSize);
        this.createMap();

    }
}