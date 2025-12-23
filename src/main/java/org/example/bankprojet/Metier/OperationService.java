package org.example.bankprojet.Metier;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.bankprojet.DTO.Odto;
import org.example.bankprojet.DTO.OpeDto;
import org.example.bankprojet.DTO.VDto;
import org.example.bankprojet.Entities.CompteBancaire;
import org.example.bankprojet.Entities.Operation;
import org.example.bankprojet.Entities.TypeOp;
import org.example.bankprojet.Exceptions.CompteInexistantException;
import org.example.bankprojet.Exceptions.SoldInsuffisantException;
import org.example.bankprojet.Mappers.MapperOp;
import org.example.bankprojet.Reposetories.ICompteBancaireRepo;
import org.example.bankprojet.Reposetories.IOperationRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class OperationService implements IOperationsService{

    private IOperationRepo opRepo;
    private ICompteBancaireRepo cbrepo;
    private MapperOp mapperOp;

    @Override
    public void debitOperation(Odto ddto)throws CompteInexistantException, SoldInsuffisantException {
        CompteBancaire cb=cbrepo.findById(ddto.getId()).get();
        if(cb == null) {
            throw new CompteInexistantException("Compte non existant");
        }
        if (cb.getSold()==0 || cb.getSold()<ddto.getMantant()) {
            throw new SoldInsuffisantException("Sold null ou pas suffisant");
        }
        Double nvSold= cb.getSold()-ddto.getMantant();
        cb.setSold(nvSold);
        cbrepo.save(cb);
        Operation op=new Operation();
        op.setId(UUID.randomUUID().toString());
        op.setType_operation(TypeOp.DEBIT);
        op.setMontant(ddto.getMantant());
        op.setDateOp(LocalDate.now());
        op.setCompteBancaire(cb);
        opRepo.save(op);
    }
    @Override
    public void creditOperation(Odto odto) throws Exception {
        CompteBancaire cb=cbrepo.findById(odto.getId()).orElse(null);
        if(cb == null) {
            throw new CompteInexistantException("Compte non existant");
        }

        Double nvSold= odto.getMantant()+cb.getSold();
        cb.setSold(nvSold);
        cbrepo.save(cb);
        Operation op=new Operation();
        op.setId(UUID.randomUUID().toString());
        op.setType_operation(TypeOp.CREDIT);
        op.setMontant(odto.getMantant());
        op.setDateOp(LocalDate.now());
        op.setCompteBancaire(cb);
        opRepo.save(op);
    }
    @Override
    public void VersementOperation(VDto vDto) throws CompteInexistantException, SoldInsuffisantException {
        CompteBancaire cbverse=cbrepo.findById(vDto.getIdCompteverse()).orElse(null);
        if(cbverse == null) {
            throw new CompteInexistantException("Compte pour verser non existant");
        }
        CompteBancaire cbrecoie=cbrepo.findById(vDto.getIdCompterecoie()).orElse(null);
        if(cbrecoie == null) {
            throw new CompteInexistantException("Compte pour recoire non existant");
        }
        Double nvSoldverse=cbverse.getSold()-vDto.getMantant();
        cbverse.setSold(nvSoldverse);
        cbrepo.save(cbverse);
        if (cbverse.getSold()==0 || cbverse.getSold()<vDto.getMantant()) {
            throw new SoldInsuffisantException("Sold null ou pas suffisant");
        }
        Double nvSoldrecoi=vDto.getMantant()+cbrecoie.getSold();
        cbrecoie.setSold(nvSoldrecoi);
        cbrepo.save(cbrecoie);
        Operation op=new Operation();
        op.setId(UUID.randomUUID().toString());
        op.setDateOp(LocalDate.now());
        op.setType_operation(TypeOp.DEBIT);
        op.setMontant(vDto.getMantant());
        op.setCompteBancaire(cbverse);
        opRepo.save(op);
        Operation op2=new Operation();
        op2.setId(UUID.randomUUID().toString());
        op2.setDateOp(LocalDate.now());
        op2.setType_operation(TypeOp.CREDIT);
        op2.setMontant(vDto.getMantant());
        op2.setCompteBancaire(cbrecoie);
        opRepo.save(op2);
    }

    @Override
    public List<OpeDto> voireOperationsAcc(String id){
       List<Operation> op= opRepo.findByCompteBancaireId(id);
        return  op.stream().
                map(operation->mapperOp.aOpeDto(operation))
                .collect(Collectors.toList());
    }
    @Override
    public List<OpeDto> voireOperationlyom(){
LocalDate lyom=LocalDate.now();
        List<Operation> op= opRepo.findAll();

        return op.stream().
        map(ope->mapperOp.aOpeDto(ope))
                .collect(Collectors.toList());
    }
}
