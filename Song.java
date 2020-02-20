public class Song implements Comparable <Song>
{
    String title;
    String artist;
    String rank;
    String stream;
   
    public Song(String r, String t, String a, String s) {
        rank = r;
        title = t;
        artist = a;
        stream = s;
    }
public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getArtist().equals(s.getArtist());
    }

    public int hashCode() {
        return artist.hashCode();
    }
   
    public int compareTo(Song s)
    {
        return artist.compareTo(s.getArtist());
    }

    public String getArtist()
    {
        return artist;
    }

    public String getBpm()
    {
        return stream;
    }

    public String getRating()
    {
        return rank;
    }

    public String getTitle()
    {
        return title;
    }
   
    public String toString() {
        return artist;
    }
    }
