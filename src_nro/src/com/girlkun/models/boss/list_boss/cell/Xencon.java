/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.girlkun.models.boss.list_boss.cell;
import com.girlkun.consts.ConstPlayer;
import com.girlkun.models.boss.*;
import com.girlkun.models.map.ItemMap;
import com.girlkun.models.player.Player;
import com.girlkun.models.skill.Skill;
import com.girlkun.server.Manager;
import com.girlkun.services.EffectSkillService;
import com.girlkun.services.Service;
import com.girlkun.services.TaskService;
import com.girlkun.utils.Util;
import com.girlkun.services.PlayerService;
import java.util.Random;

/**
 * @Stole By Arriety
 */
public class Xencon extends Boss {
    private long lastTimeHapThu;
    private int timeHapThu;
    public Xencon() throws Exception {
        super(BossID.XEN_CON_1, BossesData.XEN_CON);
    }

   @Override
    public void reward(Player plKill) {
        int[] itemDos = new int[]{555,556,557,558,559,560,561,562,563,564,565,566,567};
        int[] NRs = new int[]{17};
        int randomDo = new Random().nextInt(itemDos.length);
        int randomNR = new Random().nextInt(NRs.length);
        if (Util.isTrue(50, 100)) {
            if (Util.isTrue(3, 5)) {
                Service.gI().dropItemMap(this.zone, Util.ratiItem(zone, 15, 1, this.location.x, this.location.y, plKill.id));
                return;
            }
            Service.gI().dropItemMap(this.zone, Util.ratiItem(zone, itemDos[randomDo], 1, this.location.x, this.location.y, plKill.id));
        } else {
            Service.gI().dropItemMap(this.zone, new ItemMap(zone, NRs[randomNR], 1, this.location.x, zone.map.yPhysicInTop(this.location.x, this.location.y - 24), plKill.id));
        }
        TaskService.gI().checkDoneTaskKillBoss(plKill, this);
    }
    public void joinMap() {
        super.joinMap(); //To change body of generated methods, choose Tools | Templates.
        st = System.currentTimeMillis();
    }
    private long st;
     @Override
    public void active() {
        if (this.typePk == ConstPlayer.NON_PK) {
            this.changeToTypePK();
        }
        this.hapThu();
        this.attack();
         super.active(); //To change body of generated methods, choose Tools | Templates.
//         if (Util.canDoWithTime(st, 900000)) {
//             this.changeStatus(BossStatus.LEAVE_MAP);
//         }
    }

    private void hapThu() {
        if (!Util.canDoWithTime(this.lastTimeHapThu, this.timeHapThu) || !Util.isTrue(1, 100)) {
            return;
        }

        Player pl = this.zone.getRandomPlayerInMap();
        if (pl == null || pl.isDie()) {
            return;
        }
//        ChangeMapService.gI().changeMapYardrat(this, this.zone, pl.location.x, pl.location.y);
//        this.nPoint.dameg += (pl.nPoint.dame * 5 / 100);
//        this.nPoint.hpg += (pl.nPoint.hp * 2 / 100);
//        this.nPoint.critg++;
//        this.nPoint.calPoint();
//        PlayerService.gI().hoiPhuc(this, pl.nPoint.hp, 0);
//        pl.injured(null, pl.nPoint.hpMax, true, false);
//        Service.gI().sendThongBao(pl, "Bạn vừa bị " + this.name + " hấp thu!");
//        this.chat(2, "Ui cha cha, kinh dị quá. " + pl.name + " vừa bị tên " + this.name + " nuốt chửng kìa!!!");
//        this.chat("Haha, ngọt lắm đấy " + pl.name + "..");
//        this.lastTimeHapThu = System.currentTimeMillis();
//        this.timeHapThu = Util.nextInt(70000, 150000);
    }
    
}
