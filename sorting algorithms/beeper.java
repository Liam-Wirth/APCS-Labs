//TODO Documentation on this class
//  Arrays.toString(beeper.getLoadedInstruments());
//        System.out.println(Arrays.toString(beeper.getLoadedInstruments()));
//use above code to make a search box to choose the sound effect played
//also make it so one could choose the scale
import javax.sound.midi.*;


public class beeper {
    Synthesizer synthesizer;
    private MidiChannel channel;
    private int volume;
    public static final int MAX = 127;  //Max and min available values for Midi systems
    public static final int MIN = 0;
    private int activeOctave = OCTAVE4;
    private int instrument = 0; //Piano
    private boolean[] noteIsPlaying;
    private Instrument[] instruments;    //list of available instruments
    private int[] availableNotes;
    public final static int
            OCTAVE0 = 0,
            OCTAVE2 = 24,
            OCTAVE4 = 48,
            OCTAVE6 = 72,
            OCTAVE8 = 96;    //Octaves and their Midi counterparts
    private final static int[]
            NOTE_C = new int[]{0, 12, 24, 36, 48, 60, 72, 84, 96, 108, 120},
            NOTE_CSHARP =new int[]{1,13,25,37,49,61,73,85,97,109,121},
            NOTE_D      = new int[]{2,14,26,38,50,62,74,86,98,110,122},
            NOTE_DSHARP= new int[]{3,15,27,39,51,63,75,87,99,111,123},
            NOTE_E= new int[]{4,16,28,40,52,64,76,88,100,112,124},
            NOTE_F= new int[]{5,17,29,41,53,65,77,89,101,113,125},
            NOTE_FSHARP = new int[]{6,18,30,42,54,66,78,90,102,114,126},
            NOTE_G= new int[]{7,19,31,43,55,67,79,91,103,115,127},
            NOTE_GSHARP= new int[]{8,20,32,44,56,68,80,92,104,116},
            NOTE_A= new int[]{9,21,33,45,57,69,81,93,105,117},
            NOTE_ASHARP= new int[]{10,22,34,46,58,70,82,94,106,118},
            NOTE_B= new int[]{11,23,35,47,59,71,83,95,107,119};

    public beeper(Synthesizer synthesizer, MidiChannel channel, int volume, int activeOctave, int instrument, boolean[] noteIsPlaying, Instrument[] instruments) {
        this.synthesizer = synthesizer;
        this.channel = channel;
        this.volume = volume;
        this.activeOctave = activeOctave;
        this.instrument = instrument;
        this.noteIsPlaying = noteIsPlaying;
        this.instruments = instruments;
    }

    /**
     * Get synthesizer from Midi system, open it and upload its subsystems
     */
    public beeper() {   //default settings
        try {
            synthesizer = MidiSystem.getSynthesizer();
            instruments = synthesizer.getAvailableInstruments();
            synthesizer.open();
            MidiChannel[] allChannels = synthesizer.getChannels();
            //0 by default
            int channelN = 0;
            channel = allChannels[channelN];
            volume = channel.getController(7);
            setVolume(volume);

        } catch (MidiUnavailableException e) {
            throw new IllegalStateException("Midi support is not available!");
        }
        noteIsPlaying = new boolean[128];
    }


    /**
     * Change volume
     *
     * @param volumeLevel new volume value (type: integer, range from 0 to 127)
     */
    public void setVolume(int volumeLevel) {
        if (volumeLevel < 0 || volumeLevel > 127)
            throw new IllegalArgumentException("Midi volume level must be in the range 0 to 127");
        volume = volumeLevel;
        channel.controlChange(7, volumeLevel);
    }

    /**
     * Get volume value
     *
     * @return volume (type: integer, range from 0 to 127)
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Start playing selected note
     *
     * @param noteNumber number of note (type: integer, range from 0 to 127)
     */
    public void noteOn(int noteNumber) {
        if (noteNumber < 0 || noteNumber > 127) //https://en.scratch-wiki.info/wiki/MIDI_Notes
            throw new IllegalArgumentException("Midi note numbers must be in the range 0 to 127");
        channel.noteOn(noteNumber + activeOctave, volume);
        noteIsPlaying[noteNumber + activeOctave] = true;
    }

    /**
     * Mute selected note
     *
     * @param noteNumber number of note (type: integer, range from 0 to 127)
     */
    public void noteOff(int noteNumber) {
        if ((noteNumber + activeOctave) >= 0 && (noteNumber + activeOctave) <= 127 && noteIsPlaying[noteNumber + activeOctave]) {
            channel.noteOff(noteNumber + activeOctave);
            noteIsPlaying[noteNumber + activeOctave] = false;
        }
    }

    /**
     * min-max is 127 bozo
     */
    public void noteOnScale(int note,int sleepTime){
        note /=2;
        channel.noteOn(availableNotes[note],volume );
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        channel.allNotesOff();
    }
    /**
     * min-max is 127 bozo
     */
    public void noteOnScale(int note){
        if(note>availableNotes.length-1){
            note /=2;
            noteOnScale(note);
        }
        channel.noteOn(availableNotes[note],volume );
    }
    /**
     * Mute all notes
     */
    public void allNotesOff() {
        channel.allNotesOff();
        noteIsPlaying = new boolean[127];
    }

    /**
     * this will set the key
     * @param key is the key you want, currently only supporting major key signatures, so just type the letter name
     *              AVAILABLE OPTIONS = C C# D D# E F G G# A A# CHROMATIC
     */
    public void setKey(String key){
        switch(key.toLowerCase()){
            case "c":
                availableNotes = new int[]{0,2,4,5,7,9,11,12,14,16,17,19,21,23,24,26,28,29,31,33,35,36,38,40,41,43,45,47,48,50,52,53,55,57,59,60,62,64,65,67,69,71,72,74,76,77,79,81,83,84,86,88,89,91,93,95,96,98,100,101,103,105,107,108,110,112,113,115,117,119,120,122,124,125,127};
                break;
            case "c#" :
                availableNotes = new int[]{1,3,5,6,8,10,13,15,17,18,20,22,25,27,29,30,32,34,37,39,41,42,44,46,49,51,53,54,56,58,61,63,65,66,68,70,73,75,77,78,80,82,85,87,89,90,92,94,97,99,101,102,104,106,109,111,113,114,116,118,121,123,125,126};
                break;
            case "d":
                availableNotes = new int[]{0,12,24,36,48,60,72,84,96,108,120,2,14,26,38,50,62,74,86,98,110,122,4,16,28,40,52,64,76,88,100,112,124,5,17,29,41,53,65,77,89,101,113,125,7,19,31,43,55,67,79,91,103,115,127,9,21,33,45,57,69,81,93,105,11711,23,35,47,59,71,83,95,107,119};
                break;
            case "d#":
                availableNotes = new int[]{0,12,24,36,48,60,72,84,96,108,120,2,14,26,38,50,62,74,86,98,110,122,4,16,28,40,52,64,76,88,100,112,124,5,17,29,41,53,65,77,89,101,113,125,7,19,31,43,55,67,79,91,103,115,127,9,21,33,45,57,69,81,93,105,11711,23,35,47,59,71,83,95,107,119};
                break;
            case "e":
                availableNotes = new int[]{0,12,24,36,48,60,72,84,96,108,120,2,14,26,38,50,62,74,86,98,110,122,4,16,28,40,52,64,76,88,100,112,124,5,17,29,41,53,65,77,89,101,113,125,7,19,31,43,55,67,79,91,103,115,127,9,21,33,45,57,69,81,93,105,11711,23,35,47,59,71,83,95,107,119};
                break;
            case "f":
                availableNotes = new int[]{0,12,24,36,48,60,72,84,96,108,120,2,14,26,38,50,62,74,86,98,110,122,4,16,28,40,52,64,76,88,100,112,124,5,17,29,41,53,65,77,89,101,113,125,7,19,31,43,55,67,79,91,103,115,127,9,21,33,45,57,69,81,93,105,11711,23,35,47,59,71,83,95,107,119};
                break;
            case "f#":
                availableNotes = new int[]{0,12,24,36,48,60,72,84,96,108,120,2,14,26,38,50,62,74,86,98,110,122,4,16,28,40,52,64,76,88,100,112,124,5,17,29,41,53,65,77,89,101,113,125,7,19,31,43,55,67,79,91,103,115,127,9,21,33,45,57,69,81,93,105,11711,23,35,47,59,71,83,95,107,119};
                break;
            case "g":
                availableNotes = new int[]{0,12,24,36,48,60,72,84,96,108,120,2,14,26,38,50,62,74,86,98,110,122,4,16,28,40,52,64,76,88,100,112,124,5,17,29,41,53,65,77,89,101,113,125,7,19,31,43,55,67,79,91,103,115,127,9,21,33,45,57,69,81,93,105,11711,23,35,47,59,71,83,95,107,119};
                break;
            case "g#":
                availableNotes = new int[]{0,12,24,36,48,60,72,84,96,108,120,2,14,26,38,50,62,74,86,98,110,122,4,16,28,40,52,64,76,88,100,112,124,5,17,29,41,53,65,77,89,101,113,125,7,19,31,43,55,67,79,91,103,115,127,9,21,33,45,57,69,81,93,105,11711,23,35,47,59,71,83,95,107,119};
                break;
            case "a":
                availableNotes = new int[]{0,12,24,36,48,60,72,84,96,108,120,2,14,26,38,50,62,74,86,98,110,122,4,16,28,40,52,64,76,88,100,112,124,5,17,29,41,53,65,77,89,101,113,125,7,19,31,43,55,67,79,91,103,115,127,9,21,33,45,57,69,81,93,105,11711,23,35,47,59,71,83,95,107,119};
                break;
            case "a#":
                availableNotes = new int[]{0,12,24,36,48,60,72,84,96,108,120,2,14,26,38,50,62,74,86,98,110,122,4,16,28,40,52,64,76,88,100,112,124,5,17,29,41,53,65,77,89,101,113,125,7,19,31,43,55,67,79,91,103,115,127,9,21,33,45,57,69,81,93,105,11711,23,35,47,59,71,83,95,107,119};
                break;

        }

    }
    /**
     * Get instrument name
     *
     * @return name of active instrument (type: String)
     */
    public String getInstrumentName() {
        return instruments[instrument].getName();
    }

    /**
     * Change instrument
     *
     * @param bank       number of SoundBank
     * @param instrument instrument number
     */
    public void setInstrument(int bank, int instrument) {
        channel.programChange(bank, instrument);
        this.instrument = instrument;
    }

    /**
     * Get active channel
     *
     * @return active channel (type: MidiChannel)
     */
    public MidiChannel getChannel() {
        return channel;
    }

    /**
     * Get list of all available instruments
     *
     * @return array of instruments (type: Instrument[])
     */
    public Instrument[] getInstruments() {
        return instruments;
    }


    /**
     * Set octave
     *
     * @param activeOctave new octave (type: integer, available value = {0,24,48,72,96})
     */
    public void setActiveOctave(int activeOctave) {
        if (activeOctave == OCTAVE0 || activeOctave == OCTAVE2 || activeOctave == OCTAVE4
                || activeOctave == OCTAVE6 || activeOctave == OCTAVE8)
            this.activeOctave = activeOctave;
        else throw new IllegalArgumentException("Wrong octave");
    }

    /**
     * Get active octave
     *
     * @return octave (type: integer, available value = {0,24,48,72,96})
     */
    public int[] getOctaves() {
        return new int[]{OCTAVE0, OCTAVE2, OCTAVE4, OCTAVE6, OCTAVE8};
    }

    /**
     * Close synthesizer
     */
    public void close() {
        synthesizer.close();
    }

}