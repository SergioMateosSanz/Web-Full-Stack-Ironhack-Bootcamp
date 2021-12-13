@Service
public class PrescriptionService {

    DoctorRepository doctorRepository;
    DrugRepository drugRepository;

    @Autowired
    public PrescriptionService(DoctorRepository doctorRepository, DrugRepository drugRepository) {
        this.doctorRepository = doctorRepository;
        this.drugRepository = drugRepository;
    }
  
    public PrescriptionOrderForm fillOrder(Order order){
        // add your code here
      PrescriptionOrderForm prescriptionOrderForm = new PrescriptionOrderForm();
      prescriptionOrderForm.setPatientName(order.getPatientName());
prescriptionOrderForm.setDoctorName(doctorRepository.findById(order.getDoctorId()).get().getName());
prescriptionOrderForm.setDrugName(drugRepository.findById(order.getDrugId()).get().getName());
prescriptionOrderForm.setDosage(drugRepository.findById(order.getDrugId()).get().getDosageRate() * order.getPatientWeight());
return prescriptionOrderForm;
}

}