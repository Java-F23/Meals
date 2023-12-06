package model;

import java.io.*;
import java.util.*;

// helper class
class MyObjectOutputStream extends ObjectOutputStream {
    MyObjectOutputStream() throws IOException
    {
        super();
    }

    MyObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }

    public void writeStreamHeader() throws IOException
    {
        return;
    }
}

public class FileHandler<T> {
    private File f;
    private String fileName;

    public FileHandler(String fileName) {
        f = new File(fileName);
        this.fileName = fileName;
    }

    public ArrayList<T> readFile() {
        boolean status = false;
        try {
            f.createNewFile();
        }
        catch (Exception e) {
            System.out.println("Error Occurred: " + e);
            return null;
        }

        if (f.length() != 0) {
            try {
                FileInputStream fis = null;
                ArrayList<T> list = new ArrayList<T>();

                fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);

                T t = null;

                while (fis.available() != 0) {
                    // investigate this. throws classcastexception when adding a new meal to the file
                    // classcastexception: class Ingredient$Nutrients cannot be cast to class java.io.ObjectStreamClass?
                    t = (T)ois.readObject();
                    list.add(t);
                }

                ois.close();
                fis.close();
                status = true;
                return list;
            } catch (Exception e) {
                System.out.println("Error Occurred" + e);
                e.printStackTrace();
            }
        }
        return null;
    }

    public boolean AddNew(T t)
    {
        boolean status = false;

        if (t != null) {
            try {
                FileOutputStream fos = null;

                fos = new FileOutputStream(fileName, true);

                if (f.length() == 0) {
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(t);
                    oos.close();
                } else {
                    MyObjectOutputStream oos = null;
                    oos = new MyObjectOutputStream(fos);
                    oos.writeObject(t);
                    oos.close();
                }
                fos.close();
            } catch (Exception e) {
                System.out.println("Error Occurred" + e);
            }

            status = true;
        }

        return status;
    }

    public boolean SaveEdited(ArrayList<T> list) {
        boolean status = false;

        if (list != null) {
            try {
                FileOutputStream fos = null;

                fos = new FileOutputStream(fileName);

                ObjectOutputStream oos = new ObjectOutputStream(fos);

                for (T t : list) {
                    oos.writeObject(t);
                }

                oos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println("Error Occurred" + e);
            }

            status = true;
        }

        return status;
    }
}
