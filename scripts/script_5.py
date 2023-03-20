#!/usr/bin/env python3

import matplotlib.pyplot as plt
import numpy as np

datafiles = ["out_data/out5_1.txt", "out_data/out5_2.txt", "out_data/out5_3.txt", "out_data/out5_4.txt", "out_data/out5_5.txt"]

cm = 1/2.54
fig = plt.figure(figsize=(18*cm, 10*cm))
ax = fig.add_subplot(111)
ax.grid()
colors=["red","blue","green","purple", "gray"]

ax.set_title('Mean time to recovery (N = 8192, μ = 1 1/hours, m = 1)')
ax.set_xlabel('Number n of elementary machines in base subsystem')
ax.set_ylabel('Mean time to recovery (hours)')

ax.set_xticks([8092, 8102, 8112,8122, 8132, 8142, 8152, 8162, 8172, 8182, 8192])
label=["λ = 10^-5", "λ = 10^-6", "λ = 10^-7", "λ = 10^-8", "λ = 10^-9"]

for i in range(len(datafiles)):

    data = np.loadtxt(datafiles[i])
    x = data[:, 0]
    y = data[:, 1]
    ax.plot(x,y,'o-',markersize=2,c=colors[i], label = label[i])
plt.legend()
plt.yscale("log");
plt.ylim((None, 1.2));

fig.savefig('Tau_λ.png', dpi=1000)