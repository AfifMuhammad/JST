/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jst.Backpro;

import com.mycompany.jst.Data;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author afif
 */
public class Backprop {
    //------ input
  // Jumlah data
  int jumlah_data=80;
  // Unit Input 2
  int unit_input=100;
  // Unit Hidden 2
  int unit_hidden=6;
  // Unit Output 1
  int unit_output=1;
  
  //data latih
  double x[][]=Data.pola;
  //target
  double t[]={0.0,0.025,0.05,0.075,0.1,0.125,0.15,0.175,0.2,0.225,0.25,0.275,0.3,0.325,0.35,0.375,0.4,0.425,0.45,0.475,0.5,0.525,0.55,0.575,0.6,0.625,0.65,0.675,0.7,0.725,0.75,0.8,0.825,0.85,0.875,0.9,0.925,0.95,0.975,1,0.0,0.025,0.05,0.075,0.1,0.125,0.15,0.175,0.2,0.225,0.25,0.275,0.3,0.325,0.35,0.375,0.4,0.425,0.45,0.475,0.5,0.525,0.55,0.575,0.6,0.625,0.65,0.675,0.7,0.725,0.75,0.8,0.825,0.85,0.875,0.9,0.925,0.95,0.975,1};
 
  double alfa=0.5;
  final double stopping=0.01;
  
  //------ hidden
  //Unit input pada Hidden (z_in)
   double z_in[]=new double[unit_hidden];
  //Input pada Hidden (z)
   double z[]=new double[z_in.length];
 
  //Bias pada unit Hidden (bH)
   double v0[]={-2.608435757942943, -0.8168399805128899, -1.6737344647691963, -4.707942381142657, 13.582010124820735, -6.256440325307134};
  //Delta Bias pada unit Hidden (bHx)  --- untuk perbaikan bias Hidden
   double v0x[]=new double[v0.length];
  //Bobot antara Input-HIdden (v)
   double v[][]= {{2.7192171443960227, -13.725029531638853, -12.994187694829668, -5.467243075309694, 78.28831801963335, -30.494386510739243}, {-0.2213876037137176, -1.825386767154553, -1.1095614139579386, -0.4401303659727154, 18.85546683787963, 4.98340807071211}, {-0.12434131289276523, -2.163623975492864, -1.559280448159144, -0.2271145842471809, 19.351397052014146, 5.36875773275001}, {-2.2037747332269557, 4.038887066773447, 2.632011463024855, 0.872944561328288, -17.172615353888684, 18.259680115368713}, {-0.605015060484328, -1.3433103145303404, -1.9336522512436936, -0.24819122521165898, 19.145081778347855, 5.592384349098604}, {-0.5375564598420436, -2.0772853306516637, -1.9217230465069164, -0.7655540728816799, 18.933145782382017, 5.120223746338779}, {0.038986222660475855, -3.305180724575709, -1.542189555139502, -1.1110217331903278, 30.544750576881647, 2.860265962145214}, {-0.011228240447927912, -1.2477344284382486, -1.979157633231538, -0.8222675425686645, 19.164788562273873, 5.1320532625072905}, {-0.025026860206174294, -2.0863446241643797, -1.3835750646456637, -0.45101903474682625, 18.66817507908109, 4.989614926697807}, {2.184519669234449, -13.710908458888998, -13.348559367525196, -4.887574402499952, 79.01294775150447, -30.570851883999136}, {-0.87102398130905, -2.1371312462916108, -1.8919103056704463, -0.35208075181846277, 19.348275100195604, 5.078598028579379}, {-1.383847613548036, 1.1828654181745277, -0.7037682801309363, -0.3329201152558891, 30.88526960946034, -0.19353281933407251}, {1.362124048684182, 10.35761185159695, 4.083476145645117, -3.5981837209560585, -86.15234731193846, 44.500920334469846}, {-9.047436915943926, 30.589185495054956, 15.588310348938544, 3.202616462105174, 126.84464166623735, 31.115075017118482}, {-24.634052654284286, 80.28828895479151, 53.62581278912731, 20.88206627126615, -17.262162230821875, 56.322132142570474}, {0.030739026948193818, 42.26837162325948, 20.51219392829883, 4.364191359372398, 232.81388211724808, 18.243060115464807}, {-7.190989696592201, 7.046855069116468, 13.7988577251894, 3.948305697075462, -145.0189197749514, 92.33304285196894}, {17.781499175960846, -40.00685883346882, -41.16714764094495, -26.694817663206553, -110.15625114016595, -43.286958822685186}, {9.982122592492942, -15.309531981465566, -13.684057866142545, -13.758877528175429, -166.0769851167253, 13.026439816189534}, {-0.8732514686782583, -1.2797086818118781, -2.0015510381296804, -0.9014700343723681, 19.00888357134576, 5.338417687635972}, {0.012901885444849487, -1.7911315026044734, -1.8020327102321392, -1.1049309216790768, 19.45997634663149, 5.804609778062486}, {-11.654999645493001, 39.52873106480246, 29.013681912752446, 9.875757590374121, -244.40178650824816, 90.30495307686402}, {7.252464959583827, 4.530157681509729, 6.245202044994985, 0.471131144125897, 30.382288389340978, -8.258236294112255}, {0.10343349524078296, 48.50366570828342, 33.09736159738288, 10.835570040321677, -84.4979681713191, -1.8742325581984982}, {11.390079928655558, -13.788932827758876, -26.434995501525798, -17.317666448527348, -218.53552941767157, -173.44855800658084}, {4.910308300031209, -18.70835842997026, -9.98234178636581, 5.522114821638624, -115.41649087323434, 64.7240518261386}, {13.4846461111937, 8.830021944439116, -0.24016981319673247, -7.784610083698527, 227.33013810445524, -27.6106429469308}, {-1.8714627308541512, 14.497484498303523, 10.476355680852288, 5.999085047535697, -38.744154766493594, -30.504273770710917}, {1.054286485001079, -2.5122623415186935, -4.0765146380518225, -1.8598672490561199, -107.95350584595383, -4.0608324444643396}, {-0.14171284395553577, -2.093106149664942, -1.4091517871497887, -0.40788804031479897, 18.476272976905587, 5.779391252872347}, {-0.2077590663658855, -1.2858217448755138, -1.455858568350129, -0.35810696317695734, 18.878132938216464, 4.877805970934092}, {0.7739050796513715, -28.643548611537565, -4.240622066522082, 1.5873149758935705, 6.984603039678315, -51.97843320447044}, {14.071842826094628, -15.90461877764673, -0.1435068709252341, -5.870992603493533, 194.0440243124306, -64.83944522358517}, {0.878502195461673, 23.731565236570972, 25.754532255882836, 3.5903362210767233, 173.48075440299445, -17.34480057612475}, {9.54743258503615, -31.980788344105378, -20.53509233928805, -15.13720822579737, -56.34386215537283, 23.08245353838363}, {16.735653275660585, -32.280708902930975, -38.89089841813343, -12.763253462571143, 161.22365585362306, 7.615180599596424}, {8.122530958535505, -16.173371871555105, -21.16056187446562, -5.524409221671697, -35.158859130145096, -72.84935501039317}, {2.6485328007945377, 7.548387729784376, 2.795403104479944, 2.4902825815394363, -85.89658373626052, -41.76093537808065}, {9.5530043733888, -53.286533689855325, -41.0885392404649, -10.53241477483731, 168.28941984780172, -79.23077651038092}, {-0.4969109573263278, -1.721371421580139, -1.352325558342016, -0.6917629377069177, 18.59026680032083, 5.287127583189847}, {-0.1670624368072038, -2.2040336742192177, -1.8547757466559462, -0.227416340534619, 18.60874922754007, 4.92251818477168}, {12.994131128101447, -52.32627759043719, 5.259663703354296, 2.7070842298415942, -136.14885458054542, 53.81364463894718}, {-9.661247198249306, 11.363104855139596, 25.122763641709653, 15.409124201131956, -223.25692428174872, -65.88978841817729}, {-12.428000926057688, 69.66556067540543, 35.664857486309, 10.641273580716014, 99.86202817417279, 15.299530955631772}, {3.2312532422181235, -33.95998439583446, -23.409534179737665, -10.880721525543388, -136.65756417094698, -140.123094875409}, {24.715007028733524, -55.80202615224426, -34.277619861215776, -19.661438694648893, -176.8428633692858, -78.36355530469866}, {10.634425751713788, 14.772174712408683, 2.747781848140097, 1.0601714076180815, -101.96207670918136, -65.34085422533539}, {-5.293377688778869, 21.922019935290667, 20.3313127191493, 6.043143949305356, 116.9591903803594, -21.89970599793225}, {-31.46098716523963, 78.49123389249176, 64.30829647426523, 24.637107482564744, -362.2990563531596, 27.246497347024235}, {-0.21366848054883084, -1.4441260369595181, -1.7095914573424131, -0.6297766740746074, 18.482796207525244, 5.113438975906923}, {-4.117282227760233, 5.206385555328773, 5.018421131347916, 2.4997309451935315, 19.122815458093783, 25.269588480248842}, {2.788839092984284, 22.427298025534743, 6.283355804964034, -1.9512772355402914, 23.57516857888627, -18.894839635713595}, {3.3126212331877976, -17.22088149695725, -9.869040120634988, -8.96234847977959, -225.66177326467388, 18.15626040526224}, {-2.638207504917202, 44.364764096320336, 16.32890585812816, 1.5792610430928256, -0.20223062900553684, -38.46407204509762}, {5.150770578621793, -8.267393091697002, -16.960226329549876, -12.378352960337763, 10.2714670475717, 64.41317903344714}, {-3.179869863667797, -9.13954918268799, 13.152193697698577, 12.938951718518535, -229.28752409673473, 17.604363790437148}, {3.545073588784115, 8.825084402410376, -8.811271685321941, -5.032807507857195, 46.080420166026634, -166.899871757963}, {-6.782597746367234, 14.509682094702306, 10.408647224035894, 8.128048143985463, -49.60564302197122, -84.20186242446697}, {-3.1288865864333375, 24.90228425648684, 14.809722824611695, 4.388273873432888, -65.80936644774651, 7.818688265921389}, {-0.45627458023087625, -1.2559523029262347, -1.342354585787959, -0.39352994106385564, 19.399030735706244, 4.826321899787401}, {-1.0729838623469936, -7.863260724247736, -2.62291283480173, 1.3573991664779272, 16.51507365196831, 28.3612195411337}, {-12.17431137237088, 10.739483072744976, 22.998626422074754, 14.214322558595805, -79.98048646958762, 39.33992127988415}, {-14.024349762250791, -12.974243602105995, 0.943107367239223, 2.6519142393756736, 323.0158212106713, 147.8263084892399}, {-4.2411145640688845, -3.3286166865755233, 8.751627402526667, -1.9255728400832826, 35.5868952262114, 47.298753457795435}, {14.398789880686786, -65.74401960015605, -42.27774965475777, -12.494701948122797, 56.00303879478611, -18.016675026942067}, {-0.713486943923293, 7.512028096826991, -0.06493184888629903, 1.019038332622593, -93.04693562544358, 35.23576276221961}, {19.114045765046296, -66.24435069885381, -63.564273594653095, -26.028620740391585, -114.58787180177269, 57.943975003303876}, {0.17709067217634983, 12.35784530147386, 0.13961553291072307, -2.779672652422368, 44.62009847225134, -30.68255433133723}, {-11.49704216595603, 54.2501599212694, 40.0353599898127, 13.822176185297588, 150.41246029735078, 12.417979936865429}, {0.0670114276555751, -2.2017866344616794, -1.9648827892850316, -0.48820430347470667, 19.00605079141918, 5.121904448208569}, {-0.7794188713921705, -1.7500549442097533, -1.562676143792017, -0.5121332389133026, 19.431441055886364, 5.507169796520867}, {12.201486185336943, -54.897780656932895, -47.373180003167214, -17.529939151355542, -319.4583767012026, 4.270463547688272}, {11.364426427961392, -63.091194337529984, -37.695708597769396, -18.67628318530361, -192.01124351244383, 146.9930904405071}, {8.449871701975423, -11.745017601508682, -5.276756389448467, -4.425036653789774, 113.48331173809942, 147.6707626006831}, {2.9667649924344546, -16.41792389124198, 11.047346514259004, 5.370928820925455, -144.65396977323374, 180.610517530966}, {17.831068921695216, -19.273737557519244, -28.893431331913668, -22.30804577366114, -77.0630882285086, 50.70160656921581}, {3.8677711951301346, -10.699446992850847, -7.235467342087026, -1.957596244169515, 93.23859403506937, -34.62367458855289}, {14.460408208934451, -30.683723224429517, -55.73602052892061, -29.416317181223064, 33.11346048964073, -132.6644381227249}, {9.284366550990864, -4.9132419830966745, -22.9412206885909, -17.492549523591073, -6.473144412187653, -22.618406458282145}, {-0.61982162751788, -1.7199215706075137, -1.202876330963435, -0.37314476130972296, 18.772566521962627, 4.950061949095386}, {-0.08051130754968619, -2.1129325260888714, -2.005739888723111, -0.8725285298976313, 19.158230797562464, 5.2113010481372415}, {-10.242171783780924, 9.129341831742389, 15.922575615795331, 13.358008118169176, -2.4439978818895134, 42.69935225920215}, {-11.28639178562937, 30.794140448055504, 28.816173605945576, 13.31721539386635, -200.26118356676218, -9.99876349279916}, {12.412850368954054, -59.16620627376232, -9.958402422025543, -1.4196435861992938, -181.93504118629932, -31.043284451684332}, {0.680316454366468, 48.820507706673155, 11.83824619499462, -5.786801077695445, 89.08316477565177, 10.129478930716848}, {8.357972499917881, -22.708503751537734, -21.52258663636861, -5.626724117824891, 290.47134628318423, -54.97194580872937}, {-5.521515440077245, -4.944901726760981, 7.318407649586423, 8.388550480469268, 0.7509024596739715, 70.10345376202213}, {-10.29710586628701, 17.75082264923691, 25.298053296109064, 10.977478134557913, -274.8552876760976, 126.92138240837883}, {-0.7126621622007044, -1.6498566978461013, -1.691324848694897, -0.3716007572931894, 18.7515074678921, 4.824016218303556}, {-0.43952607001771965, -1.7340422739998613, -1.2381792721980724, -0.1801440480758838, 18.822493757578666, 4.900026417039839}, {2.4216281147415843, -13.704778539911636, -13.660156718862806, -5.568386436268353, 78.9067359965064, -30.512121333991463}, {-0.1643872482530105, -2.3390182361451974, -3.5668172959661386, -1.4038615205734273, 42.535732251027945, -7.601918195973899}, {-0.5253547630638148, -1.9779834112655907, -1.098196470667512, -0.4614926352813451, 19.231149651065603, 5.00278376801374}, {0.06034183720426537, -2.1684686209482593, -1.414767323723814, -0.3496038887927422, 19.073825331471678, 5.160420554699763}, {-0.2558806599972378, -0.8415645000280927, -1.7225943115770377, -1.104916226986097, 18.61747017213902, 5.813458298624778}, {-0.7714168316620554, -1.2385626593300614, -1.9275964759071316, -0.8140528047778568, 18.500328631199775, 5.45352296178145}, {-0.10220522904021728, -1.4612039719674856, -1.27084541200896, -0.6688998264319488, 18.535257933416222, 5.5014978554922065}, {-0.2708446329732143, -1.598884051090778, -1.290035644470181, -0.48255421662662223, 18.76436153304112, 5.293670505846404}, {0.08353289096446967, -1.315094154580996, -1.2823070591785017, -1.0808131335374906, 18.666675474002876, 5.162586851612548}, {2.666104303781479, -13.998778918281378, -13.123572926527226, -5.840629209178934, 78.8085753457016, -30.664423786379817}};
  //Delta Bobot antara Input-HIdden (vx) --- untuk perbaikan  bobot Input-Hidden
   double vx[][]=new double[v.length][v[0].length];
 
  //Kesalahan pada setelah Hidden (Err_z)
   double Err_in[]=new double[unit_hidden];
  //Kesalahan pada Hidden (Err_z)
   double Err_z[]=new double[unit_hidden];
 
  //------ output
  //Unit Output pada Output (y_in)
   double y_in[]=new double[unit_output];
  //Output pada Output (y)
   double y[]=new double[y_in.length];
 
  //Bias pada unit Output (bO)
   double w0[]={133.48981588271144};
  //Delta Bias pada unit Output (bOx)  ---- untuk perbaikan bias pada Output
   double w0x[]=new double[w0.length];
  //Bobot antara Hidden-Output <img class="wp-smiley emoji" draggable="false" alt="(w)" src="https://s0.wp.com/wp-content/mu-plugins/wpcom-smileys/wordpress.svg" style="height: 1em; max-height: 1em;" width="16" height="16">
   double w[][]={{-14.240622215934753}, {66.40099282217064}, {45.219101074993}, {19.500789832617293}, {-146.82660230586058}, {113.48732875868546}};
  //Delta Bobot antara Hidden-Output (wx) --- untuk perbaikan bobot Hidden-Output
   double wx[][]=new double[w.length][w[0].length];
 
  //Kesalahan pada Ouput (Err_y)
   double Err_y[]=new double[unit_output];
 
  //------------- aha
  //Minimum Error Kuadrat ERR
   double ERR;
   
   //konstruktor
   public Backprop(){
       //initRandom();
   }
   
   public void initRandom(){
       for(int i=0; i<unit_hidden; i++){
           v0[i] = ThreadLocalRandom.current().nextDouble(-0.5, 0.5);
           w[i][0] = ThreadLocalRandom.current().nextDouble(-0.5, 0.5);
           for(int j=0; j<unit_input; j++){
               v[j][i] = ThreadLocalRandom.current().nextDouble(-0.5, 0.5);
           }
       }
       System.out.println("v0 = "+Arrays.toString(v0));
       System.out.println("v = "+Arrays.toString(v));
       System.out.println("w0 = "+Arrays.toString(w0));
       System.out.println("w = "+Arrays.toString(w));
   }
   
   //penentuan berhenti atau lanjut
  double cekStop(){
    double akumY=0;
    //~ itung z_in dan z
    for(int h=0; h<jumlah_data; h++){
     for(int j=0; j<unit_hidden; j++){
      //itung sigma xi vij
      double jum_xv=0;
      for(int i=0; i<unit_input; i++){
         double cc=x[h][i]*v[i][j];
         jum_xv=jum_xv+cc;
         //System.out.println(x[h][j]);
      }
      z_in[j]=v0[j]+jum_xv;
      //itung z
      z[j]=1/(1+(double)Math.exp(-z_in[j]));
      //System.out.println(" dan z= "+z[j]);
     }
 
     //~ itung y_in dan y     (output)
      double cxc=0;
      for(int k=0; k<unit_output; k++){
        double jum_zw=0;
        for(int j=0; j<unit_hidden; j++){
          double cc=z[j]*w[j][k];
          jum_zw=jum_zw+cc;
        }
        y_in[k]=w0[k]+jum_zw;
        y[k]=1/(1+(double)Math.exp(-y_in[k]));
        akumY = akumY + Math.pow((t[h]-y[k]),2);
        //System.out.println(t[h]+"-"+y[k]+"="+(t[k]-y[k]));
      }
    }
    double E = 0.5 * akumY;
    //System.out.println(E);
    return E;
  }
  
  public void learn(){
    do{
      //~ itung z_in dan z
      for(int h=0; h<jumlah_data; h++){
        for(int j=0; j<unit_hidden; j++){
          //itung sigma xi vij
          double jum_xv=0;
          for(int i=0; i<unit_input; i++){
            double cc=x[h][i]*v[i][j];
            jum_xv=jum_xv+cc;
          }
          z_in[j]=v0[j]+jum_xv;
          //itung z
          z[j]=1/(1+(double)Math.exp(-z_in[j]));
        }
 
        //~ itung y_in dan y     (output)
        double cxc=0;
        for(int k=0; k<unit_output; k++){
          double jum_zw=0;
          for(int j=0; j<unit_hidden; j++){
            double cc=z[j]*w[j][k];
            jum_zw=jum_zw+cc;
          }
          y_in[k]=w0[k]+jum_zw;
          y[k]=1/(1+(double)Math.exp(-y_in[k]));
          //System.out.println(y[k]);
        }
        //System.out.println(y[0]);
 
        //ngitung error output dan delta bias dan delta bobot
        for(int k=0; k<unit_output; k++){
          //error otput
          Err_y[k]=(t[h]-y[k])*y[k]*(1-y[k]);
          //System.out.println(Err_y[k]);
 
          double  cc=0;
          for(int j=0; j<unit_hidden; j++){
            //delta bobot hO
            wx[j][k]=alfa*Err_y[k]*z[j];
            //delta bias hO
            w0x[k]=alfa*Err_y[k];
            //System.out.println("delta wx = "+wx[j][k]);
          }
          //System.out.println("delta w0 = "+w0x[k]);
        }
 
        //ngitung error hiden dan delta bias dan delta bobot
        for(int j=0; j<unit_hidden; j++){
          double cc=0;
          for(int k=0; k<unit_output; k++){
            cc = cc + (Err_y[k]*w[j][k]);
          }
          // eror sebelum output / setelah hidden
          Err_in[j]=cc;
          //System.out.println(Err_in[j]);
 
          // eror hidden               (t[h]-y[k])*y[k]*(1-y[k]);
          Err_z[j]=Err_in[j]*(z[j])*(1-z[j]);
          //System.out.println(Err_z[j]);
 
          for(int i=0; i<unit_input; i++){
            //delta bobot iH
            vx[i][j]=alfa*Err_z[j]*x[h][i];
            //System.out.println("delta vx = "+vx[i][j]);
          }
          //delta bias  hidden
          v0x[j]=alfa*Err_z[j];
          //System.out.println("delta v0 = "+v0x[j]);
          //System.out.println(alfa+" "+Err_z[j]+" "+v0x[j]);
        }
 
        //update bobot dan bias
        //update bobot bias outpuut
        for(int j=0; j<unit_hidden; j++){
          for(int k=0; k<unit_output; k++){
            w[j][k]=w[j][k]+wx[j][k];
            //w0[k]=w0[k]+w0x[k];
            //System.out.println("w = "+w[j][k]);
          }
        }
        for(int k=0; k<unit_output; k++){
          //w[j][k]=w[j][k]+wx[j][k];
          w0[k]=w0[k]+w0x[k];
          //System.out.println("w0 = "+w0[k]);
        }
 
        //update bobot bias hidden
        for(int i=0; i<unit_input; i++){
          for(int j=0; j<unit_hidden; j++){
            v[i][j]=v[i][j]+vx[i][j];
            //v0[j]=v0[j]+v0x[j];
            //System.out.println("v = "+v[i][j]);
          }
        }
 
        for(int j=0; j<unit_hidden; j++){
          //v[i][j]=v[i][j]+vx[i][j];
          v0[j]=v0[j]+v0x[j];
          //System.out.println("v0 = "+v0[j]);
        }
      }
      System.out.println("MSE => "+cekStop());
    }while(cekStop()>stopping);
 
 
    /// bagian ini untuk ngeprint doang...
    /// jadi dihapus gpp
 
    System.out.println("w = "+Arrays.deepToString(w));
    System.out.println("v = "+Arrays.deepToString(v));
    System.out.println("w0 = "+Arrays.toString(w0));
    System.out.println("v0 = "+Arrays.toString(v0));
  }
  
  public String test(double inputan[])
  {
      String x="";
    //pada hidden
    for(int j=0; j<unit_hidden; j++)
    {
      double cc=0;
      for(int i=0; i<inputan.length; i++){
        cc= cc + (inputan[i]*v[i][j]);
      }
      z_in[j] = v0[j] +cc;
      z[j] = 1/(1+(double)Math.exp(-z_in[j]));
    }
 
    //pada ouotpr
    for(int k=0; k<unit_output; k++){
      double cc = 0;
      for(int j=0; j<unit_hidden; j++){
        cc = cc + z[j]*w[j][k];
      }
      y_in[k] = w0[k]+cc;
 
      double y = 1/(1+(double)Math.exp(-y_in[k]));
 
//      if(y>0.5)
//       y=1;
//      else
//       y=0;
      System.out.println("Output "+y);
      
      double h = y;
        if(h<0.025){
            x = "Adam";
        }else if (h<0.05){
            x = "Ahmad";
        }else if (h<0.075){
            x = "Ais";
        }else if (h<0.1){
            x = "Arif";
        }else if (h<0.125){
            x = "Ayuk";
        }else if (h<0.15){
            x = "Bayu";
        }else if (h<0.175){
            x = "Beni";
        }else if (h<0.2){
            x = "Cici";
        }else if (h<0.225){
            x = "Dani";
        }else if (h<0.25){
            x = "Doni";
        }else if (h<0.275){
            x = "Fahrul";
        }else if (h<0.3){
            x = "Hani";
        }else if (h<0.325){
            x = "Hanum";
        }else if (h<0.35){
            x = "Heri";
        }else if (h<0.375){
            x = "Iis";
        }else if (h<0.4){
            x = "Ila";
        }else if (h<0.425){
            x = "Irfan";
        }else if (h<0.45){
            x = "Maman";
        }else if (h<0.475){
            x = "Mar";
        }else if (h<0.5){
            x = "Maya";
        }else if (h<0.525){
            x = "Muftia";
        }else if (h<0.55){
            x = "Nafi";
        }else if (h<0.575){
            x = "Nisa";
        }else if (h<0.6){
            x = "Oki";
        }else if (h<0.625){
            x = "Ozi";
        }else if (h<0.65){
            x = "Ratih";
        }else if (h<0.675){
            x = "Rian";
        }else if (h<0.7){
            x = "Riko";
        }else if (h<0.725){
            x = "Rio";
        }else if (h<0.75){
            x = "Rotul";
        }else if (h<0.775){
            x = "Sopyan";
        }else if (h<0.8){
            x = "Susi";
        }else if (h<0.825){
            x = "Tami";
        }else if (h<0.85){
            x = "Tyas";
        }else if (h<0.875){
            x = "Wina";
        }else if (h<0.9){
            x = "Zila";
        }else if (h<0.925){
            x = "Yani";
        }else if (h<0.95){
            x = "Yuni";
        }else if (h<0.975){
            x = "Zila";
        }else if (h<1){
            x = "Ziya";
        }
    }
    return x;
  }

    public void setUnit_hidden(int unit_hidden) {
        this.unit_hidden = unit_hidden;
    }

    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }
  
  
}
