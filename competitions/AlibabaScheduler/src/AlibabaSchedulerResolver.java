import java.io.*;
import java.util.*;

public class AlibabaSchedulerResolver {

    static class Machine{
        String id;
        double CPU;
        double Memory;
        double Disk;
        double P;
        double M;
        double PM;

        public Machine(String id, double CPU, double Memory, double Disk, double P, double M, double PM){
            this.id = id;
            this.CPU = CPU;
            this.Memory = Memory;
            this.Disk = Disk;
            this.P = P;
            this.M = M;
            this.PM = PM;
        }
    }

    static class App{
        String id;
        List<Double> CPU;
        List<Double> Memory;
        double Disk;
        double P;
        double M;
        double PM;
        List<String> instances;
        HashMap<String, Integer> constraints;

        public App(String id, List<Double> CPU, List<Double> Memory, double Disk, double P, double M, double PM){
            this.id = id;
            this.CPU = CPU;
            this.Memory = Memory;
            this.Disk = Disk;
            this.P = P;
            this.M = M;
            this.PM = PM;
            instances = new ArrayList<>();
            constraints = new HashMap<>();
        }
    }

    public static void main(String[] args) throws IOException {
        // machine_resources.csv
        BufferedReader bs = new BufferedReader(new FileReader(new File("machine_resources.csv")));
        String data[];
        HashMap<String, Machine> machines = new HashMap<>();
        HashMap<String, List<String>> result = new HashMap<>();
        for (String line = bs.readLine(); line != null; line = bs.readLine()){
            data = line.split(",");
            machines.put(data[0], new Machine(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6])));
            result.put(data[0], new ArrayList<>());
        }
        // app_resources.csv
        bs = new BufferedReader(new FileReader(new File("app_resources.csv")));
        HashMap<String, App> apps = new HashMap<>();
        List<Double> cpu, memory;
        String dCPU[], dMemory[];
        for (String line = bs.readLine(); line != null; line = bs.readLine()){
            data = line.split(",");
            cpu = new ArrayList<>();
            dCPU = data[1].split("\\|");
            for(int i = 0; i < dCPU.length; i++)
                cpu.add(Double.parseDouble(dCPU[i]));
            memory = new ArrayList<>();
            dMemory = data[2].split("\\|");
            for(int i = 0; i < dMemory.length; i++)
                memory.add(Double.parseDouble(dMemory[i]));
            apps.put(data[0], new App(data[0], cpu, memory, Double.parseDouble(data[3]), Double.parseDouble(data[4]), Double.parseDouble(data[5]), Double.parseDouble(data[6])));
        }
        // instance_deploy.csv
        bs = new BufferedReader(new FileReader(new File("instance_deploy.csv")));
        for (String line = bs.readLine(); line != null; line = bs.readLine()){
            data = line.split(",");
            apps.get(data[1]).instances.add(data[0]);
        }
        // app_interference.csv
        bs = new BufferedReader(new FileReader(new File("app_interference.csv")));
        for (String line = bs.readLine(); line != null; line = bs.readLine()){
            data = line.split(",");
            apps.get(data[0]).constraints.put(data[1], Integer.parseInt(data[2]));
        }
        // Resolver

    }
}
