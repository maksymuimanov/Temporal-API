import {Button} from "@/components/ui/button.tsx";

export const HeadingContent = () => {
    return (
        <div className="h-200 pt-50 pl-30 pr-30 pb-20 flex items-center relative">
            <div className="flex-1"></div>
            <div className="flex-4">
                <p className="pl-40 pr-40 text-6xl text-center mb-15 text-white">
                    <strong> Minecraft Modding Tool for Reducing Boilerplate </strong>
                </p>
                <p className="pl-50 pr-50 text-xl text-center text-white">
                    Code your own Minecraft Mod without thinking about datagen, registries, etc.
                    Think only about adding new content
                </p>
                <div className="flex justify-center mt-10">
                    <Button className="mr-5 cursor-pointer" variant="default">
                        Getting Started
                    </Button>
                    <Button className="cursor-pointer" variant="outline">
                        Documentation
                    </Button>
                </div>
            </div>
            <div className="flex-1"></div>
        </div>
    );
};