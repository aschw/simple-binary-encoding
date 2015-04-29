package uk.co.real_logic.sbe.generation.java;

public final class ReflectionUtil
{
    static int getSbeSchemaVersion(final Object encoder) throws Exception
    {
        return getInt(encoder, "sbeSchemaVersion");
    }

    static int getSbeBlockLength(final Object encoder) throws Exception
    {
        return getInt(encoder, "sbeBlockLength");
    }

    private static int getInt(final Object object, final String fieldName) throws Exception
    {
        return (int) get(object, fieldName);
    }

    public static Object get(final Object object, final String fieldName) throws Exception
    {
        return object.getClass().getMethod(fieldName).invoke(object);
    }

    static String getMake(final Object decoder) throws Exception
    {
        return (String) decoder.getClass().getMethod("make").invoke(decoder);
    }

    static void putMake(final Object encoder,
                        final String value) throws Exception
    {
        encoder.getClass().getMethod("make", String.class).invoke(encoder, value);
    }

    static void putSerialNumber(final Object encoder,
                                final long serial) throws Exception
    {
        encoder.getClass()
               .getMethod("serialNumber", long.class)
               .invoke(encoder, serial);
    }

    static long getSerialNumber(final Object reader) throws Exception
    {
        return (long) reader.getClass().getMethod("serialNumber").invoke(reader);
    }

    static int getLimit(final Object flyweight) throws Exception
    {
        return getInt(flyweight, "limit");
    }

    static Object getExtras(final Object object) throws Exception
    {
        return get(object, "extras");
    }

    static Object setCruiseControl(final Object extras, final boolean value) throws Exception
    {
        return extras.getClass().getMethod("cruiseControl", boolean.class).invoke(extras, value);
    }

    static boolean getCruiseControl(final Object extras) throws Exception
    {
        return (boolean) extras.getClass().getMethod("cruiseControl").invoke(extras);
    }

    public static int getCapacity(final Object flyweight) throws Exception
    {
        return getInt(flyweight, "capacity");
    }

    public static void setCapacity(final Object flyweight, int value) throws Exception
    {
        flyweight
            .getClass()
            .getMethod("capacity", int.class)
            .invoke(flyweight, value);
    }
}
