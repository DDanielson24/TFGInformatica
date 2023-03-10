/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package org.TFGInformatica;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class PuntoDeMedicion extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4490928446538705185L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PuntoDeMedicion\",\"namespace\":\"org.TFGInformatica\",\"fields\":[{\"name\":\"idelem\",\"type\":\"int\"},{\"name\":\"descripcion\",\"type\":\"string\"},{\"name\":\"carga\",\"type\":\"int\"},{\"name\":\"nivelServicio\",\"type\":\"int\"},{\"name\":\"st_x\",\"type\":\"float\"},{\"name\":\"st_y\",\"type\":\"float\"},{\"name\":\"fechaActualizacion\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PuntoDeMedicion> ENCODER =
      new BinaryMessageEncoder<PuntoDeMedicion>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PuntoDeMedicion> DECODER =
      new BinaryMessageDecoder<PuntoDeMedicion>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PuntoDeMedicion> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PuntoDeMedicion> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PuntoDeMedicion> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<PuntoDeMedicion>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PuntoDeMedicion to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PuntoDeMedicion from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PuntoDeMedicion instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PuntoDeMedicion fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private int idelem;
   private java.lang.CharSequence descripcion;
   private int carga;
   private int nivelServicio;
   private float st_x;
   private float st_y;
   private java.lang.CharSequence fechaActualizacion;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PuntoDeMedicion() {}

  /**
   * All-args constructor.
   * @param idelem The new value for idelem
   * @param descripcion The new value for descripcion
   * @param carga The new value for carga
   * @param nivelServicio The new value for nivelServicio
   * @param st_x The new value for st_x
   * @param st_y The new value for st_y
   * @param fechaActualizacion The new value for fechaActualizacion
   */
  public PuntoDeMedicion(java.lang.Integer idelem, java.lang.CharSequence descripcion, java.lang.Integer carga, java.lang.Integer nivelServicio, java.lang.Float st_x, java.lang.Float st_y, java.lang.CharSequence fechaActualizacion) {
    this.idelem = idelem;
    this.descripcion = descripcion;
    this.carga = carga;
    this.nivelServicio = nivelServicio;
    this.st_x = st_x;
    this.st_y = st_y;
    this.fechaActualizacion = fechaActualizacion;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return idelem;
    case 1: return descripcion;
    case 2: return carga;
    case 3: return nivelServicio;
    case 4: return st_x;
    case 5: return st_y;
    case 6: return fechaActualizacion;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: idelem = (java.lang.Integer)value$; break;
    case 1: descripcion = (java.lang.CharSequence)value$; break;
    case 2: carga = (java.lang.Integer)value$; break;
    case 3: nivelServicio = (java.lang.Integer)value$; break;
    case 4: st_x = (java.lang.Float)value$; break;
    case 5: st_y = (java.lang.Float)value$; break;
    case 6: fechaActualizacion = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'idelem' field.
   * @return The value of the 'idelem' field.
   */
  public int getIdelem() {
    return idelem;
  }


  /**
   * Sets the value of the 'idelem' field.
   * @param value the value to set.
   */
  public void setIdelem(int value) {
    this.idelem = value;
  }

  /**
   * Gets the value of the 'descripcion' field.
   * @return The value of the 'descripcion' field.
   */
  public java.lang.CharSequence getDescripcion() {
    return descripcion;
  }


  /**
   * Sets the value of the 'descripcion' field.
   * @param value the value to set.
   */
  public void setDescripcion(java.lang.CharSequence value) {
    this.descripcion = value;
  }

  /**
   * Gets the value of the 'carga' field.
   * @return The value of the 'carga' field.
   */
  public int getCarga() {
    return carga;
  }


  /**
   * Sets the value of the 'carga' field.
   * @param value the value to set.
   */
  public void setCarga(int value) {
    this.carga = value;
  }

  /**
   * Gets the value of the 'nivelServicio' field.
   * @return The value of the 'nivelServicio' field.
   */
  public int getNivelServicio() {
    return nivelServicio;
  }


  /**
   * Sets the value of the 'nivelServicio' field.
   * @param value the value to set.
   */
  public void setNivelServicio(int value) {
    this.nivelServicio = value;
  }

  /**
   * Gets the value of the 'st_x' field.
   * @return The value of the 'st_x' field.
   */
  public float getStX() {
    return st_x;
  }


  /**
   * Sets the value of the 'st_x' field.
   * @param value the value to set.
   */
  public void setStX(float value) {
    this.st_x = value;
  }

  /**
   * Gets the value of the 'st_y' field.
   * @return The value of the 'st_y' field.
   */
  public float getStY() {
    return st_y;
  }


  /**
   * Sets the value of the 'st_y' field.
   * @param value the value to set.
   */
  public void setStY(float value) {
    this.st_y = value;
  }

  /**
   * Gets the value of the 'fechaActualizacion' field.
   * @return The value of the 'fechaActualizacion' field.
   */
  public java.lang.CharSequence getFechaActualizacion() {
    return fechaActualizacion;
  }


  /**
   * Sets the value of the 'fechaActualizacion' field.
   * @param value the value to set.
   */
  public void setFechaActualizacion(java.lang.CharSequence value) {
    this.fechaActualizacion = value;
  }

  /**
   * Creates a new PuntoDeMedicion RecordBuilder.
   * @return A new PuntoDeMedicion RecordBuilder
   */
  public static org.TFGInformatica.PuntoDeMedicion.Builder newBuilder() {
    return new org.TFGInformatica.PuntoDeMedicion.Builder();
  }

  /**
   * Creates a new PuntoDeMedicion RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PuntoDeMedicion RecordBuilder
   */
  public static org.TFGInformatica.PuntoDeMedicion.Builder newBuilder(org.TFGInformatica.PuntoDeMedicion.Builder other) {
    if (other == null) {
      return new org.TFGInformatica.PuntoDeMedicion.Builder();
    } else {
      return new org.TFGInformatica.PuntoDeMedicion.Builder(other);
    }
  }

  /**
   * Creates a new PuntoDeMedicion RecordBuilder by copying an existing PuntoDeMedicion instance.
   * @param other The existing instance to copy.
   * @return A new PuntoDeMedicion RecordBuilder
   */
  public static org.TFGInformatica.PuntoDeMedicion.Builder newBuilder(org.TFGInformatica.PuntoDeMedicion other) {
    if (other == null) {
      return new org.TFGInformatica.PuntoDeMedicion.Builder();
    } else {
      return new org.TFGInformatica.PuntoDeMedicion.Builder(other);
    }
  }

  /**
   * RecordBuilder for PuntoDeMedicion instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PuntoDeMedicion>
    implements org.apache.avro.data.RecordBuilder<PuntoDeMedicion> {

    private int idelem;
    private java.lang.CharSequence descripcion;
    private int carga;
    private int nivelServicio;
    private float st_x;
    private float st_y;
    private java.lang.CharSequence fechaActualizacion;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(org.TFGInformatica.PuntoDeMedicion.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.idelem)) {
        this.idelem = data().deepCopy(fields()[0].schema(), other.idelem);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.descripcion)) {
        this.descripcion = data().deepCopy(fields()[1].schema(), other.descripcion);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.carga)) {
        this.carga = data().deepCopy(fields()[2].schema(), other.carga);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.nivelServicio)) {
        this.nivelServicio = data().deepCopy(fields()[3].schema(), other.nivelServicio);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.st_x)) {
        this.st_x = data().deepCopy(fields()[4].schema(), other.st_x);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.st_y)) {
        this.st_y = data().deepCopy(fields()[5].schema(), other.st_y);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.fechaActualizacion)) {
        this.fechaActualizacion = data().deepCopy(fields()[6].schema(), other.fechaActualizacion);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing PuntoDeMedicion instance
     * @param other The existing instance to copy.
     */
    private Builder(org.TFGInformatica.PuntoDeMedicion other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.idelem)) {
        this.idelem = data().deepCopy(fields()[0].schema(), other.idelem);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.descripcion)) {
        this.descripcion = data().deepCopy(fields()[1].schema(), other.descripcion);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.carga)) {
        this.carga = data().deepCopy(fields()[2].schema(), other.carga);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.nivelServicio)) {
        this.nivelServicio = data().deepCopy(fields()[3].schema(), other.nivelServicio);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.st_x)) {
        this.st_x = data().deepCopy(fields()[4].schema(), other.st_x);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.st_y)) {
        this.st_y = data().deepCopy(fields()[5].schema(), other.st_y);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.fechaActualizacion)) {
        this.fechaActualizacion = data().deepCopy(fields()[6].schema(), other.fechaActualizacion);
        fieldSetFlags()[6] = true;
      }
    }

    /**
      * Gets the value of the 'idelem' field.
      * @return The value.
      */
    public int getIdelem() {
      return idelem;
    }


    /**
      * Sets the value of the 'idelem' field.
      * @param value The value of 'idelem'.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder setIdelem(int value) {
      validate(fields()[0], value);
      this.idelem = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'idelem' field has been set.
      * @return True if the 'idelem' field has been set, false otherwise.
      */
    public boolean hasIdelem() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'idelem' field.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder clearIdelem() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'descripcion' field.
      * @return The value.
      */
    public java.lang.CharSequence getDescripcion() {
      return descripcion;
    }


    /**
      * Sets the value of the 'descripcion' field.
      * @param value The value of 'descripcion'.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder setDescripcion(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.descripcion = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'descripcion' field has been set.
      * @return True if the 'descripcion' field has been set, false otherwise.
      */
    public boolean hasDescripcion() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'descripcion' field.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder clearDescripcion() {
      descripcion = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'carga' field.
      * @return The value.
      */
    public int getCarga() {
      return carga;
    }


    /**
      * Sets the value of the 'carga' field.
      * @param value The value of 'carga'.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder setCarga(int value) {
      validate(fields()[2], value);
      this.carga = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'carga' field has been set.
      * @return True if the 'carga' field has been set, false otherwise.
      */
    public boolean hasCarga() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'carga' field.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder clearCarga() {
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'nivelServicio' field.
      * @return The value.
      */
    public int getNivelServicio() {
      return nivelServicio;
    }


    /**
      * Sets the value of the 'nivelServicio' field.
      * @param value The value of 'nivelServicio'.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder setNivelServicio(int value) {
      validate(fields()[3], value);
      this.nivelServicio = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'nivelServicio' field has been set.
      * @return True if the 'nivelServicio' field has been set, false otherwise.
      */
    public boolean hasNivelServicio() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'nivelServicio' field.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder clearNivelServicio() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'st_x' field.
      * @return The value.
      */
    public float getStX() {
      return st_x;
    }


    /**
      * Sets the value of the 'st_x' field.
      * @param value The value of 'st_x'.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder setStX(float value) {
      validate(fields()[4], value);
      this.st_x = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'st_x' field has been set.
      * @return True if the 'st_x' field has been set, false otherwise.
      */
    public boolean hasStX() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'st_x' field.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder clearStX() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'st_y' field.
      * @return The value.
      */
    public float getStY() {
      return st_y;
    }


    /**
      * Sets the value of the 'st_y' field.
      * @param value The value of 'st_y'.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder setStY(float value) {
      validate(fields()[5], value);
      this.st_y = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'st_y' field has been set.
      * @return True if the 'st_y' field has been set, false otherwise.
      */
    public boolean hasStY() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'st_y' field.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder clearStY() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'fechaActualizacion' field.
      * @return The value.
      */
    public java.lang.CharSequence getFechaActualizacion() {
      return fechaActualizacion;
    }


    /**
      * Sets the value of the 'fechaActualizacion' field.
      * @param value The value of 'fechaActualizacion'.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder setFechaActualizacion(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.fechaActualizacion = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'fechaActualizacion' field has been set.
      * @return True if the 'fechaActualizacion' field has been set, false otherwise.
      */
    public boolean hasFechaActualizacion() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'fechaActualizacion' field.
      * @return This builder.
      */
    public org.TFGInformatica.PuntoDeMedicion.Builder clearFechaActualizacion() {
      fechaActualizacion = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PuntoDeMedicion build() {
      try {
        PuntoDeMedicion record = new PuntoDeMedicion();
        record.idelem = fieldSetFlags()[0] ? this.idelem : (java.lang.Integer) defaultValue(fields()[0]);
        record.descripcion = fieldSetFlags()[1] ? this.descripcion : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.carga = fieldSetFlags()[2] ? this.carga : (java.lang.Integer) defaultValue(fields()[2]);
        record.nivelServicio = fieldSetFlags()[3] ? this.nivelServicio : (java.lang.Integer) defaultValue(fields()[3]);
        record.st_x = fieldSetFlags()[4] ? this.st_x : (java.lang.Float) defaultValue(fields()[4]);
        record.st_y = fieldSetFlags()[5] ? this.st_y : (java.lang.Float) defaultValue(fields()[5]);
        record.fechaActualizacion = fieldSetFlags()[6] ? this.fechaActualizacion : (java.lang.CharSequence) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PuntoDeMedicion>
    WRITER$ = (org.apache.avro.io.DatumWriter<PuntoDeMedicion>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PuntoDeMedicion>
    READER$ = (org.apache.avro.io.DatumReader<PuntoDeMedicion>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.idelem);

    out.writeString(this.descripcion);

    out.writeInt(this.carga);

    out.writeInt(this.nivelServicio);

    out.writeFloat(this.st_x);

    out.writeFloat(this.st_y);

    out.writeString(this.fechaActualizacion);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.idelem = in.readInt();

      this.descripcion = in.readString(this.descripcion instanceof Utf8 ? (Utf8)this.descripcion : null);

      this.carga = in.readInt();

      this.nivelServicio = in.readInt();

      this.st_x = in.readFloat();

      this.st_y = in.readFloat();

      this.fechaActualizacion = in.readString(this.fechaActualizacion instanceof Utf8 ? (Utf8)this.fechaActualizacion : null);

    } else {
      for (int i = 0; i < 7; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.idelem = in.readInt();
          break;

        case 1:
          this.descripcion = in.readString(this.descripcion instanceof Utf8 ? (Utf8)this.descripcion : null);
          break;

        case 2:
          this.carga = in.readInt();
          break;

        case 3:
          this.nivelServicio = in.readInt();
          break;

        case 4:
          this.st_x = in.readFloat();
          break;

        case 5:
          this.st_y = in.readFloat();
          break;

        case 6:
          this.fechaActualizacion = in.readString(this.fechaActualizacion instanceof Utf8 ? (Utf8)this.fechaActualizacion : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










