package dz06;

import java.util.HashSet;
import java.util.Random;

public class notebook {

    HashSet<Integer> HashIds = new HashSet<>();
    Integer Id;
    String Display;
    String Matrix;
    String Model;
    String Processor;
    Integer Hard;
    String TypeHard;
    String Os;
    Integer Ram;
    String Color;
    Double Weight;
    Double Height;
    Double Width;
    Double Price;
    Integer Count;

    public notebook() {
        Id = GenerateId();
        Matrix = "-";
        Model = "-";
        Processor = "-";
        Hard = 0;
        TypeHard = "-";
        Os = "-";
        Ram = 0;
        Color = "-";
        Weight = 0.0;
        Height = 0.0;
        Width = 0.0;
        Price = 0.0;
        Count = 0;
    }

    public notebook(
            String Display,
            String Matrix,
            String Model,
            String Processor,
            Integer Hard,
            String TypeHard,
            String Os,
            Integer Ram,
            String Color,
            Double Weight,
            Double Height,
            Double Width,
            Double Price,
            Integer Count) {
        this.Id = GenerateId();
        this.Display = Display;
        this.Matrix = Matrix;
        this.Model = Model;
        this.Processor = Processor;
        this.Hard = Hard;
        this.TypeHard = TypeHard;
        this.Os = Os;
        this.Ram = Ram;
        this.Color = Color;
        this.Weight = Weight;
        this.Height = Height;
        this.Width = Width;
        this.Price = Price;
        this.Count = Count;
    }

    public Integer GenerateId() {
        Integer numberId = new Random().nextInt(1000, 10001);
        if (HashIds.contains(numberId))
            GenerateId();
        else
            HashIds.add(numberId);
        return numberId;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Код товара: %d, Модель: %s\n\t" +
                "Дисплей: %s Матрица: %s Процессор: %s SSD(Гб) %s\n\t" +
                "Тип жесткого диска: %s ОС: %s Оперативная память: %d Цвет: %s\n\t" +
                "Вес: %,.2f Высота: %,.2f Ширина: %,.2f Цена: %,.2f Кол-во на складе: %d\n",
                Id, Model, Display, Matrix, Processor, Hard, TypeHard, Os, Ram, Color, Weight, Height, Width, Price,
                Count);
    }

    public boolean isModel(String modelFilter, HashSet<Object> Notebooks) {
        return Notebooks.getClass().getName().matches(modelFilter);
    }

}
