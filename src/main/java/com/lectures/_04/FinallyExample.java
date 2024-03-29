package com.lectures._04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

public class FinallyExample {


  public static void main(String[] args) throws IOException {
    copyFile("C:\\tmp\\in.txt", "C:\\tmp\\out.txt");
  }

  public static void copyFile(String inputFileName, String outputFileName) throws UncheckedIOException {
    try (FileInputStream in = new FileInputStream(inputFileName) {
      @Override
      public void close() throws IOException {
        throw new IOException("IOException from FileInputStream");
      }
    };
        FileOutputStream out = new FileOutputStream(outputFileName) {
          @Override
          public void close() throws IOException {
            throw new IOException("IOException from FileOutputStream");

          }
        }) {
      copyFile(in, out);
    } catch (IOException e) {
      System.out.println("Caught");
      e.printStackTrace();
    }
//    catch (IOException e) {
//      System.out.println("Caught IOException and rethrow UncheckedIOException");
//      throw new UncheckedIOException(e);
//    }
  }

  public static void copyFileOldStyle(String inputFileName, String outputFileName) throws UncheckedIOException {
    RuntimeException thrown = null;
    FileInputStream in = null;
    FileOutputStream out = null;
    try {
      in = new FileInputStream(inputFileName) {
        @Override
        public void close() throws IOException {
          throw new IOException("IOException from FileInputStream");
        }
      };
      out = new FileOutputStream(outputFileName) {
        @Override
        public void close() throws IOException {
          throw new IOException("IOException from FileOutputStream");

        }
      };
      copyFile(in, out);
    } catch (IOException ex) {
      System.out.println("Caught IOException and rethrow UncheckedIOException");
      thrown = new UncheckedIOException(ex);
    } finally {
      System.out.println("Closing " + inputFileName);
      if (thrown == null) {
        if (in != null) {
          try {
            in.close();
          } catch (IOException e) {
            new UncheckedIOException("File wasn't closed " + inputFileName, e);
          }
        }
      }
      System.out.println("Closing " + outputFileName);
      if (out != null) {
        try {
          out.close();
        } catch (IOException e) {
          new UncheckedIOException("File wasn't closed " + inputFileName, e);
        }
      }
    }
  }

  public static void copyFile(FileInputStream in, FileOutputStream out) throws IOException {
//    throw new IOException("Exception from method copyFile");
  }
}
